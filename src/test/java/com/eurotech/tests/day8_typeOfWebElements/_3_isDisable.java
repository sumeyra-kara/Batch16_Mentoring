package com.eurotech.tests.day8_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_isDisable {
    /*
     * go to https://the-internet.herokuapp.com/dynamic_controls
     * locate disable text bar
     * verify that the element is disabled
     * locate and click the Enable button
     * send "The element is now enabled!!" keys to the bar
     * verify that the element is enabled.
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
    public void disableElement() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textBar = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        Assert.assertFalse(textBar.isEnabled());
        WebDriverFactor.wait(3);
        WebElement enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
        enableButton.click();
        WebDriverFactor.wait(3);
        textBar.sendKeys("The element is now enabled!!");
        WebDriverFactor.wait(3);
        Assert.assertTrue(textBar.isEnabled());
    }

    @Test
    public void disableElementTask() {
        /*
         * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
         * locate pumpkin element
         * verify that the element is enabled
         * verify that the element is selected
         * verify that the element is displayed
         * locate cabbage element
         * verify that the element is NOT enabled
         * verify that the element is NOT selected
         * verify that the element is displaye
         */
    }
}
