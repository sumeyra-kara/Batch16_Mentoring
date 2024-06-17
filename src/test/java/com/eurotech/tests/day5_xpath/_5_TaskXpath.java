package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _5_TaskXpath {
    public static void main(String[] args) {
        /*
         * Task
         * open chrome browser
         * go to http://www.eurotech.study/
         * click I understand button and accept cookies (use xPath-contains text)
         * locate login button (use xPath - known attribute (class) ) ----3
         * click login button
         * locate email address input box (use xPath -starts-with (id)) ---4
         * send "abc@abc.com" into email address input box
         * locate second login button (use xPath - * -> use star in xPath formula )--5
         * click Login button
         * close browser
         */


        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        WebElement cookies = driver.findElement(By.xpath("//button[contains(text(),'I understand')]"));
        cookies.click();

        //3
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='btn btn-light']"));
        loginButton.click();

        //4
        WebElement emailButton = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-input-email')]"));
        emailButton.sendKeys("abc@abc.com");

        //5
        WebElement login = driver.findElement(By.xpath("//input[starts-with(@id,'loginpage-form-b')]"));
        login.click();

        WebDriverFactor.wait(2);

        driver.close();


    }
}
