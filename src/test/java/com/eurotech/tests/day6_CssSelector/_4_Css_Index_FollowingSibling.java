package com.eurotech.tests.day6_CssSelector;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _4_Css_Index_FollowingSibling {
    public static void main(String[] args) {
        /*
         * navigate to https://demoqa.com/automation-practice-form
         * send "hasan@hasan.com" to email box with css index
         * send "Bağcılar/İstanbul" to current address box with css sibling
         * close driver
         * --------------
         * cssSyntax--->tagName :nth-of-type(indexNumber)
         * cssSyntax--->tagName :nth-child(indexNumber)
         * NOTE: sadece aynı parent altındaki web elementlerde kullanılır..
         *
         * css following sibling (~)
         * cssSyntax:tagName[]~tagName[]
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement userEmail = driver.findElement(By.cssSelector("input[id='userEmail']"));
        userEmail.sendKeys("hasan@hasan.com");
        WebDriverFactor.wait(2);

        WebElement adresse = driver.findElement(By.xpath("(//div[@class='col-md-3 col-sm-12']/following-sibling::div)[11]/textarea"));
        adresse.sendKeys("Bağcılar/İstanbul");

        WebDriverFactor.wait(2);

       //driver.close();


    }
}
