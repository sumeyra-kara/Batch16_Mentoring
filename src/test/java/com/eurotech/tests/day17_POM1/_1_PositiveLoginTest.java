package com.eurotech.tests.day17_POM1;

import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;

public class _1_PositiveLoginTest extends TestBase {

    @Test
    public void loginTest1() {
        /**
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * POM version
         */
        LoginPage loginPage = new LoginPage();
        driver.get(ConfigReader.get("url"));
        loginPage.emailBox.sendKeys(ConfigReader.get("email"));
        loginPage.passwordBox.sendKeys(ConfigReader.get("password"));
        loginPage.loginButton.click();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void loginTest2() {
        /*
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * POM version (FindBys and FindAll)
         */
        LoginPage loginPage = new LoginPage();
        driver.get(ConfigReader.get("url"));
        loginPage.emailBoxWithFindBys.sendKeys(ConfigReader.get("email"));
        loginPage.passwordBoxWithFindBys.sendKeys(ConfigReader.get("password")+ Keys.ENTER);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void loginTest3() {
        /*
         * navigate to https://www.krafttechexlab.com/login
         * login with valid credentials
         * verify success login with page title (contains Dashboard)
         * login with non-parameter method
         */
        LoginPage loginPage = new LoginPage();
        driver.get(ConfigReader.get("url"));
        loginPage.login();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
}
