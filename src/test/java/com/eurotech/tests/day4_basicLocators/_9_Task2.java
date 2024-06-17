package com.eurotech.tests.day4_basicLocators;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _9_Task2 {
    public static void main(String[] args) {
        /*
         * go to the url - "https://www.browserstack.com/users/sign_up"
         * maximize the window
         * accept cookies if any ,
         * fill in the blanks with the faker class
         * click "Term of service" checkbox
         * and close the window
         *
         * hint: u can use any locator you want
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");

        driver.manage().window().maximize();

        WebElement cookies = driver.findElement(By.id("accept-cookie-notification"));
        cookies.click();

        WebElement fullName = driver.findElement(By.id("user_full_name"));
        fullName.sendKeys("Sümeyra Kara");

        WebElement eMail = driver.findElement(By.id("user_email_login"));
        eMail.sendKeys("sumeyrakara@gmail.com");

        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("12345");

        WebElement termsOfService = driver.findElement(By.id("terms-url"));
        termsOfService.click();

        WebDriverFactor.wait(3);

        driver.close();



    }
}
