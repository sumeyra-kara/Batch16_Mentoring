package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_Task {
    public static void main(String[] args) {
        /*
         * class task
         * open chrome browser and go to http://www.eurotech.study/
         * click I understand button and accept cookies (by xPath with contains (attribute))
         * locate sign up by xPath with contains (text)
         * click Sign Up
         * locate Name input box by xPath (starts with) and send to box "Ahmet"
         * locate email input box by xPath (more than one attribute) and send the box "aaa@aaa.com"
         * locate password input box by xPath (more than one attribute with "and") and type in "123456"
         * locate confirm password input box by xPath (more than one attribute with "or") and type in "123456"
         * locate Sign In link by xPath (with index) --- use only tag
         * click Sign In link
         * close browser.
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("http://www.eurotech.study/");
        WebDriverFactor.wait(2);

        WebElement cookies = driver.findElement(By.xpath("//button[contains(@aria-label,'cookies')]"));
        cookies.click();
        WebDriverFactor.wait(2);

        WebElement signUpElement = driver.findElement(By.xpath("//a[contains(text(),'Up')]"));
        signUpElement.click();
        WebDriverFactor.wait(2);


        WebElement nameBox = driver.findElement(By.xpath("//input[starts-with(@name, 'na')]"));
        nameBox.sendKeys("Ahmet");
        WebDriverFactor.wait(2);

        WebElement eMailBox = driver.findElement(By.xpath("//input[@type='email'][@placeholder='Email Address']"));
        eMailBox.sendKeys("aaa@aaa.com");
        WebDriverFactor.wait(2);

        /*WebElement signUp = driver.findElement(By.xpath("//a[contains(text(),'Up')]"));
        signUp.click();
        WebDriverFactor.wait(2);
         */

        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password' and @name='password']"));
        passwordBox.sendKeys("123456");
        WebDriverFactor.wait(2);

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='signuppage-form-pw2-input' or @name='password2']"));
        confirmPassword.sendKeys("123456");
        WebDriverFactor.wait(2);

        WebElement signUpClick = driver.findElement(By.xpath("(//a)[2]"));
        signUpClick.click();

        WebDriverFactor.wait(2);

        driver.close();

    }
}
