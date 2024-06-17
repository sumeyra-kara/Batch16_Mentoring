package com.eurotech.tests.day9_ListOfElements_DropDowns;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _1_ListOfWebElements_findElements {
    /*
     * navigate to https://www.saucedemo.com/
     * locate login form elements with one locator (username box, password box and login button)
     * send "standard_user" to username box
     * send "secret_sauce" to password box
     * click Login button
     * then take all product names to a web element list and print the text of elements
     * verify that first web element text is "Sauce Labs Backpack"
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
       // driver.close();
    }
    @Test @Ignore
    public void findElements(){
        driver.get("https://www.saucedemo.com/");
        List<WebElement> inputs = driver.findElements(By.xpath("//input"));
        inputs.get(0).sendKeys("standard_user");
        inputs.get(1).sendKeys("secret_sauce");
        inputs.get(2).click();

        List<WebElement> products = driver.findElements(By.xpath("//a[@href='#']/div"));
        List<String> products2 = new ArrayList<>(); // bos list

        for (WebElement item : products){
            products2.add(item.getText());
        }
        String expectedName = "Sauce Labs Backpack";
        Assert.assertTrue(products2.stream().anyMatch(e-> e.equals(expectedName)));

    }

    @Test
    public void task(){
        /*
         * https://demoqa.com/elements adresine git
         * soldaki ana başlıkları tek bir locator ile locate et ve bunları bir liste kaydet
         * listin size'ını al.
         * size'ın 6 olduğunu doğrula.
         * listedeki başlık elementlerinin textlerini yazdır. (For each)
         */
        driver.get("https://demoqa.com/elements");
        List<WebElement> menuElements = driver.findElements(By.cssSelector(".menu-list"));
        System.out.println("menuElements.size() = " + menuElements.size());
        int actualSize = menuElements.size();
        Assert.assertEquals(actualSize,6);

        for (WebElement text : menuElements){
            System.out.println(text.getText());
        }

    }


}
