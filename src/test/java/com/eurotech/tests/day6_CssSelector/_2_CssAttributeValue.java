package com.eurotech.tests.day6_CssSelector;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _2_CssAttributeValue {
    public static void main(String[] args) {
        /*
         * navigate to http://www.eurotech.study/
         * click cookies button with one css attribute value
         * take DevEx text and print with css multiple attribute value (and)
         * take main text and print with css multiple attribute value (or)
         * close driver
         * --------------------
         * [attribute='value']
         * tagName[attribute='value']
         * ----------------------
         * birden çok attribute ile css'de locate etme:
         * [attribute1='value1'][attribute2='value2'] (and)
         * tagName[attribute1='value1'][attribute2='value2'] (and)
         *
         * [attribute1='value1'],[attribute2='value2'] (or)
         * tagName[attribute1='value1'],[attribute2='value2'] (or)
         */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        WebElement cookies = driver.findElement(By.cssSelector(""));
        cookies.click();
    }
}
