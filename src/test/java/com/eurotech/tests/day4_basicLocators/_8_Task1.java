package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _8_Task1 {
    public static void main(String[] args) {
        /*
         * open a chrome browser driver and navigate to https://www.demoblaze.com/
         * locate Sign up link by using id and get text of web element then print the text
         * locate previous and next link at the bottom of the page by using name and get text of web element then print the text
         * locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
         * locate Product Store at the left top of the page by using class name and get text of web element then print the text
         * locate Nokia Lumia 1520 by using link text and get text of web element then print the text
         * locate Nexus 6 by using partial link text and get text of web element then print the text
         * close the driver
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://www.demoblaze.com/");

        WebElement signUpElement = driver.findElement(By.id("signin2"));
        System.out.println("signUpElement.getText() = " + signUpElement.getText());


        // locate previous and next link at the bottom of the page by using name and get text of web element then print the text
        WebElement previous = driver.findElement(By.linkText("Previous"));
        System.out.println("previous.getText() = " + previous.getText());

        WebElement next = driver.findElement(By.linkText("Next"));
        System.out.println("next.getText() = " + next.getText());

        // locate Samsung Galaxy S6 by using tagname and get text of web element then print the text
        WebDriverFactor.wait(3);
        WebElement e = driver.findElement(By.tagName("h4"));
        System.out.println("e.getText() = " + e.getText());

        WebElement samsungElement = driver.findElement(By.xpath("//a[@class='hrefch']")); // xpath ile
        System.out.println("samsungElement.getText() = " + samsungElement.getText());

        // locate Product Store at the left top of the page by using class name and get text of web element then print the text
        WebElement productStore = driver.findElement(By.className("navbar-brand"));
        System.out.println("p.getText() = " + productStore.getText());
        productStore.click();
        WebDriverFactor.wait(3);

        // locate Nokia Lumia 1520 by using link text and get text of web element then print the text
        WebElement nokiaLumia = driver.findElement(By.linkText("Nokia lumia 1520"));
        String a = nokiaLumia.getText();
        System.out.println(a);
        WebDriverFactor.wait(3);


       // locate Nexus 6 by using partial link text and get text of web element then print the text
        WebElement nexus6 = driver.findElement(By.partialLinkText("xus 6"));
        System.out.println("nexus6.getText() = " + nexus6.getText());

        driver.close();


    }
}
