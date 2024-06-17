package com.eurotech.tests.day3_webElementIntro;

import com.eurotech.utilities.WebDriverFactor;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_Task {
    public static void main(String[] args) {
       /*
        * Open chore browser
        * navigate to https://www.amazon.com.tr/
        * write "Java" to the search bar
        * click search button
        * get result for text
        * verify that the text contains "Java"
        */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Java");

        WebElement click = driver.findElement(By.id("nav-search-submit-button"));
        click.click();

        WebElement searchResultElement =driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        String actualText = searchResultElement.getText();
        String expectedText = "Java";

        if (actualText.equals(expectedText)){
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

    }
}
