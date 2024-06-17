package com.eurotech.tests.day5_xpath;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class _6_Task {
    static WebDriver driver;
    /*
    https://demowebshop.tricentis.com/
     */

    public static void main(String[] args) {
        driver = WebDriverFactor.getDriver("chrome");
        driver.get("https://demowebshop.tricentis.com/");
        WebDriverFactor.wait(3);

        addToCard("14.1-inch Laptop");
        WebDriverFactor.wait(4);

    }



    public static void addToCard (String productName){
        driver.findElement(By.xpath("//h2/a[text()='"+productName+"']/../following-sibling::div[3]//input")).click();
    }
}
