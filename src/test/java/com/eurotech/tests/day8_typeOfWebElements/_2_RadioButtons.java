package com.eurotech.tests.day8_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_RadioButtons {
    /*
     * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
     * locate yellow element
     * verify that the element is NOT selected
     * click the element
     * verify that the element is selected
     *
     * locate blue element
     * verify that the element is displayed
     * click the element
     * verify that the blue element is selected
     * verify that the yellow element is NOT selected
     * * isSelected()  ----> bir elementin seçili olup olmadığını verir  :  true/false
     * isDisplayed()  ----> bir elementin görünür olup olmadığını verir  :  true/false
     * isEnabled()  ----> bir element ile etkileşime (click, sendKeys vb.) geçilip geçilemeyeceğini verir  :  true/false
     *                    isEnabled() durumunun tersi disabled ile ifade edilir  ama isDisable() metodu yoktur...
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void radioButtonTest() {
        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement yellow = driver.findElement(By.xpath("//input[@value='yellow']"));
        Assert.assertFalse(yellow.isSelected());
        yellow.click();
        Assert.assertTrue(yellow.isSelected());

        WebElement blue = driver.findElement(By.xpath("//input[@value='blue']"));
        Assert.assertTrue(blue.isDisplayed());
        blue.click();
        Assert.assertTrue(blue.isSelected());
        Assert.assertFalse(yellow.isSelected());
    }

    @Test
    public void radioButtonTestTask() {
        /*
         * https://demoqa.com/automation-practice-form
         * locate female gender element
         * verify that the element is NOT selected
         * verify that the element is displayed
         * click the element
         * verify that the element is selected
         * ipucu: eğer elementten istediğiniz sonucu alamıyorsanız.. aynı yeri gösteren diğer elementleri deneyin....!!!
         */
        driver.get("https://demoqa.com/automation-practice-form");
    }
}
