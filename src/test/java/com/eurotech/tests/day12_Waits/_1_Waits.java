package com.eurotech.tests.day12_Waits;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class _1_Waits {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        // driver.close();
    }

    @Test
    public void waitTest1() {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/2
         * click start button
         * verify that "Hello World!" is visible
         */

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();

        WebElement helloWorldElement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        Assert.assertTrue(helloWorldElement.isDisplayed());
    }

    @Test
    public void test2() {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/2
         * click start button
         * verify that "Hello World!" is visible
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();
        WebElement helloWorldElement = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(helloWorldElement)).click();
        Assert.assertTrue(helloWorldElement.isDisplayed());
    }

    @Test
    public void test3() {
        /**
         * navigate to https://the-internet.herokuapp.com/dynamic_loading/2
         * click start button
         * verify that "Hello World!" is visible
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement until = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        boolean bl = until.isDisplayed();
        Assert.assertTrue(bl);
    }
}