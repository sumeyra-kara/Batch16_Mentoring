package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_Practice {
    public static void main(String[] args) {
        /*
         * open chrome browser
         * go to "https://demoqa.com/login"
         * enter "test" into the username box
         * VERIFY that "test" is displayed in the username box
         * enter "Test.!123" into the password box
         * click on login button
         * VERIFY that username is "test"


         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://demoqa.com/login");

        WebElement id = driver.findElement(By.id("userName"));
        id.sendKeys("test");

        String actualId= id.getAttribute("value");
        String expectedId ="username";

        if (actualId.equals(expectedId)){
            System.out.println("id passed");
        } else {
            System.out.println("id failed");
        }

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Test.!123");

        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        WebDriverFactor.wait(2);

        WebElement testElement = driver.findElement(By.id("userName-value"));

        String expectedAttribute="test";
        String actualAttribute=testElement.getText();
        if (expectedAttribute.equals(actualAttribute)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }










    }
}
