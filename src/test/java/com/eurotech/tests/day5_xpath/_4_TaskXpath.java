package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_TaskXpath {
    public static void main(String[] args) {
        /*
         * task
         * navigate to https://demoqa.com/automation-practice-form
         * locate first name input box with xPath (parent-child relations)---2
         * send "Ayşegül" to the input box
         * locate sports checkbox with xPath (parent-child relations)---3
         * click to the checkbox
         * locate Student Registration Form element by xPath (parent-child relations)--4
         * get the text of web element and print it
         * close the driver#
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        //2
        WebElement firstName = driver.findElement(By.xpath("(//div/input)[1]"));
        firstName.sendKeys("Aysegül");
        WebDriverFactor.wait(3);

        //3
        WebElement sports = driver.findElement(By.xpath("(//div/label)[10]"));
        sports.click();
        WebDriverFactor.wait(2);

        //4
        WebElement text = driver.findElement(By.xpath("//div/h5"));
        System.out.println("text.getText() = " + text.getText());

        driver.close();


    }
}
