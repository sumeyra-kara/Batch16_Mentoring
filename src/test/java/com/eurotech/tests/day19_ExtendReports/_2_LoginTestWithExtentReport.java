package com.eurotech.tests.day19_ExtendReports;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_LoginTestWithExtentReport extends TestBase {
    @Test
    public void pozitifLoginTest() {
        /*
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * login with non-parameter method
         */

        extentLogger = report.createTest("TC001 Pozitif Login Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Navigate to "+ConfigReader.get("url"));
        driver.get(ConfigReader.get("url"));

        extentLogger.info("Login with valid credentials");
        loginPage.login();

        extentLogger.info("Verify success login with page title");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        extentLogger.pass("Pass!");
    }

    @Test
    public void negatifLoginTest() {
        /*
         * navigate to https://www.krafttechexlab.com/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */
        extentLogger = report.createTest("TC002 Negatif Login Test");
        LoginPage loginPage = new LoginPage();

        extentLogger.info("Navigate to "+ConfigReader.get("url"));
        driver.get(ConfigReader.get("url"));

        extentLogger.info("Enter a valid email");
        loginPage.emailBoxWithFindBys.sendKeys(ConfigReader.get("email"));

        extentLogger.info("Enter a wrong password");
        loginPage.passwordBoxWithFindBys.sendKeys("wrongPassword");

        extentLogger.info("Click Login Button");
        loginPage.loginButton.click();

        extentLogger.info("Verify that the related message is displayed");
        String expectedMessage = "Password is incorrect. Please check07";
        String actualMessage = loginPage.getWrongEmailMessageText();
        BrowserUtils.scrollToElement(loginPage.emailBox);
        Assert.assertEquals(actualMessage,expectedMessage);

        extentLogger.pass("Pass!");
    }
}


