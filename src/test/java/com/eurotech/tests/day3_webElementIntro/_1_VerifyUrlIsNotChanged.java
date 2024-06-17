package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_VerifyUrlIsNotChanged {
    public static void main(String[] args) {
        /*
         * Task
         * open chrome browser
         * go to https://www.krafttechexlab.com/login
         * click on login button
         * VERIFY that url is not changed
         */


        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();

        String expectedUrl="https://www.krafttechexlab.com/login";
        String actualUrl= driver.getCurrentUrl();

        if (expectedUrl.equals(actualUrl)){
            System.out.println("Url test passed");
        } else {
            System.out.println("Url test failed");
        }

        driver.quit();


    }
}
