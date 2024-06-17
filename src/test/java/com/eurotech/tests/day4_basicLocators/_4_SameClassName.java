package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_SameClassName {
    public static void main(String[] args) {
        /*
         * open chrome browser and navigate to https://demoqa.com/text-box
         * locate Full Name label web element by using class name locator
         * get the text of web element and print it
         * close driver.
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://demoqa.com/text-box/");

        WebElement fullName = driver.findElement(By.className("form-label"));
        System.out.println("fullName.getText() = " + fullName.getText());

        driver.close();
    }
}
