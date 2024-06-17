package com.eurotech.tests.day17_POM1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserTypes;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_NegativeLoginTest extends TestBase {

    @Test
    public void wrongPasswordTest() {
        /*
         * navigate to https://www.krafttechexlab.com/login
         * type in correct username
         * type in wrong password
         * verify that user cannot login
         * and takes the warning message: "Password is incorrect. Please check"
         */
        LoginPage loginPage = new LoginPage();

        driver.get(ConfigReader.get("url"));
        loginPage.emailBoxWithFindBys.sendKeys(ConfigReader.get("email"));
        loginPage.passwordBoxWithFindBys.sendKeys("wrongPassword");
        loginPage.loginButton.click();

       String expectedMessage = "Password is incorrect. Please check";
        String actualMessage = loginPage.getWrongEmailMessageText();
        BrowserUtils.scrollToElement(loginPage.emailBox);
       Assert.assertEquals(actualMessage,expectedMessage);

    }

    @Test
    public void wrongEmailTest() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * type in wrong username
         * type in correct password
         * verify that user cannot login
         * and takes the warning message: "Email address is incorrect. Please check"
         */
        LoginPage loginPage = new LoginPage();

        driver.get(ConfigReader.get("url"));
        loginPage.emailBoxWithFindBys.sendKeys("falseemail");
        loginPage.passwordBoxWithFindBys.sendKeys(ConfigReader.get("password"));
        loginPage.loginButton.click();
        String expectedMessage ="Email address is incorrect. Please check";
        String actualMessage = loginPage.getWrongEmailMessageText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(actualMessage,expectedMessage);
    }
}
