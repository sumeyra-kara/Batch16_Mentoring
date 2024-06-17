package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _6_LinkText {
    public static void main(String[] args) {
        /*
         * open chrome browser and navigate to http://www.eurotech.study/
         * accept cookies if any
         * locate Login button web element by using link text locator
         * get the text of web element and print it
         * click to the web element
         * close driver.

         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        WebElement cookies = driver.findElement(By.id("rcc-confirm-button"));
        cookies.click();

        WebElement login = driver.findElement(By.linkText("Login"));
        System.out.println("login.getText() = " + login.getText());

        login.click();

        WebDriverFactor.wait(2);
        driver.close();

        /*
         * 1- a tag'ı ve href attribute'u olan web elementlerde kullanılır...
         * 2- <a class="btn btn-light" href="https://www.uzunihsan.com/login">ABCDEF</a> --> web elementinde ABCDEF link text kısmıdır..
         * 3- text kısmının tamamı alınmalıdır..
         */
    }
}
