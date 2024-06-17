package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _4_TaskGetAttribute {
    public static void main(String[] args) {
        /*
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies
         * take the value of the attributes (class and href) of the login button and print the values.
         * click login button
         * send "sdfsdsd" into email address input box
         * click Login button
         * get the message which appears on the email input box
         * VERIFY that the message contains "Please include an '@' in the email address."
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://www.eurotech.study/");

        WebElement cookies  = driver.findElement(By.id("rcc-confirm-button"));
        cookies.click();

        WebElement login = driver.findElement(By.xpath("//a[@class='btn btn-light']"));

        String classAttribute = login.getAttribute("class");
        System.out.println("classAttribute = " + classAttribute);

        String hrefAttribute = login.getDomAttribute("href");
        System.out.println("hrefAttribute = " + hrefAttribute);
        login.click();

        WebElement eMailAdresseButton = driver.findElement(By.id("loginpage-input-email"));
        eMailAdresseButton.sendKeys("sdfsdsd");

        WebElement loginButton = driver.findElement(By.id("loginpage-form-btn"));
        loginButton.click();
        //driver.manage().window().maximize();

        String actualMessage = eMailAdresseButton.getAttribute("validationMessage");
        System.out.println("message = " + actualMessage);
        String expectedMessage = "Please include an '@' in the email address.";

        if (actualMessage.contains(expectedMessage)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }

        //driver.close();


    }
}
