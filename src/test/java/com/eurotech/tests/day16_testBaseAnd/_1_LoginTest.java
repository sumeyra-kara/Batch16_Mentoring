package com.eurotech.tests.day16_testBaseAnd;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigReader;
import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class _1_LoginTest extends TestBase {

    @Test
    public void loginTest1() {
        driver.get(ConfigReader.get("url"));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(ConfigReader.get("email"));

        WebElement password  = driver.findElement(By.id("yourPassword"));
        password.sendKeys(ConfigReader.get("password"));

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h2")));
        WebElement username = driver.findElement(By.tagName("h2"));
        String expected ="sevgi";
        String actual = username.getText();
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void loginTest2() {
        LoginPage loginPage = new LoginPage();
        driver.get(ConfigReader.get("url"));
        loginPage.emailBox.sendKeys(ConfigReader.get("email"));
        loginPage.passwordBox.sendKeys(ConfigReader.get("password"));
        loginPage.loginButton.click();

        DashboardPage dashboardPage = new DashboardPage();
        String actualUserName = dashboardPage.userName.getText();
        String expected ="sevgi";
        Assert.assertEquals(actualUserName,expected);
    }

    @Test
    public void loginTest3() {
        LoginPage loginPage = new LoginPage();
        driver.get(ConfigReader.get("url"));
        loginPage.login(ConfigReader.get("email"),ConfigReader.get("password"));
        DashboardPage dashboardPage = new DashboardPage();

        String actualUserName = dashboardPage.userName.getText();
        String expected ="sevgi";
        Assert.assertEquals(actualUserName,expected);
    }
}
