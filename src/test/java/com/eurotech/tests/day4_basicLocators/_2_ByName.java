package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_ByName {
    public static void main(String[] args) {
        /*
         * open chrome browser and navigate to https://testpages.herokuapp.com/styled/basic-html-form-test.html
         * locate username input box by using name locator
         * send a random name to the box
         * clear the box
         * send another name to the box
         * get the second name which sent to the box and assign it to a string variable
         * print the second name
         * make verification
         * close driver.
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Sümeyra Kara");

        username.clear();

        username.sendKeys("Sevda Kara");
        String value = username.getAttribute("value");
        System.out.println("value = " + value);

        if (value.equals("Sevda Kara"))
            System.out.println("Passed");
        else
            System.out.println("Failed");

        WebDriverFactor.wait(2);

        driver.close();
        /*
         * 1. name'ler id.ler gibi dinamik olmazlar..
         * 2. ancak birden fazla web elementin name attribute değeri aynı olabilir. Bu durumda locate işleminde kullanılmaları halinde
         * selenium her zaman ilkine gider ve o web element ile işlem yapar..
         */

    }
}
