package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class _3_TaskXpath {
    static WebDriver driver;
    public static void main(String[] args) {
        /* ZOR TASK
         * open a chrome browser
         * navigate to http://opencart.abstracta.us/index.php?route=common/home
         * locate "iPhone Add to Cart Button" with the name of product iPhone --2
         * then click to the add to cart button
         * take the text of success message which appears after the click
         * verify that the message contains "Success"
         * close driver
         */

        driver= WebDriverFactor.getDriver("chrome");
        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        WebDriverFactor.wait(2);
        //2
        addToCard("iPhone");
        WebDriverFactor.wait(3);
        WebElement messageElement = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible"));
        String actualText = messageElement.getText();
        System.out.println("actualText = " + actualText);
        if (actualText.contains("Success"))
            System.out.println("Passed");
        else
            System.out.println("Failed");


        //driver.close();


    }

    public static void addToCard (String productName){
        driver.findElement(By.xpath("//a[text()='"+productName+"']/../../following-sibling::div/button[.//span]")).click();
    }
}
