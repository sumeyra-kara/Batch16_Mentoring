package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _1_Task {

    public static void main(String[] args) {
        /*
         * open chrome
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any (use xPath formula with known attribute value)
         * locate search bar with xPath formula with known attribute value
         * send "Selenium" word to the search bar
         * locate search button with xPath formula with known attribute value
         * click search button
         * Get the search result by the formula of the text feature of Xpath (two ways)
         * get the text of web element and print it.
         * close driver
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://www.amazon.com.tr/");

        WebElement cookies = driver.findElement(By.xpath("//input[@id='sp-cc-accept']"));
        cookies.click();

        WebElement searchBar = driver.findElement(By.xpath("//input[@type='text']"));
        searchBar.sendKeys("Selenium");

        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();

        WebElement searchResult = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        System.out.println("searchResult.getText() = " + searchResult.getText());

        driver.close();




    }
}
