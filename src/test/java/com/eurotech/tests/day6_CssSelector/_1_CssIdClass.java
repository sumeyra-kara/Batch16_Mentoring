package com.eurotech.tests.day6_CssSelector;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_CssIdClass {
    public static void main(String[] args) {
        /*
         * navigate to http://www.eurotech.study/
         * click cookies button with css id
         * click Sign Up button css class
         * send "Ahmet" to name box by css id with tag
         * click register button by css class with tag
         * close driver
         *--------------------
         * #id
         * tagName#id
         * -------------------
         * .className
         * tagName.className
         * Note: eğer class name'de boşluk varsa silinip yerine . (nokta) konulur
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        WebElement cookies = driver.findElement(By.cssSelector("#rcc-confirm-button"));
        cookies.click();

        WebElement signUp = driver.findElement(By.cssSelector("a[class='btn btn-primary']"));
        signUp.click();
        WebDriverFactor.wait(2);

        WebElement nameButton = driver.findElement(By.cssSelector("input#signuppage-form-name-input"));
        nameButton.sendKeys("Ahmet");

        WebElement register = driver.findElement(By.cssSelector(".btn.btn-primary"));
        register.click();

        WebDriverFactor.wait(2);

        driver.close();





    }
}
