package com.eurotech.tests.day8_typeOfWebElements;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_Checkboxes {
    /*
     * navigate to http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
     * locate option 3 element
     * verify that the element is selected
     * click the element
     * verify that the element is NOT selected
     *
     * locate option 2
     * verify that the element is NOT selected
     * click the element
     * verify that the element is selected
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
       // driver.close();
    }

    @Test
    public void checkboxTest1(){

        driver.get("http://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement option3 = driver.findElement(By.cssSelector("[value='option-3']"));
        Assert.assertTrue(option3.isSelected());
        option3.click();
        Assert.assertFalse(option3.isSelected());

        WebElement option2 = driver.findElement(By.cssSelector("[value='option-2']"));
        Assert.assertFalse(option2.isSelected());
        option2.click();
        Assert.assertTrue(option2.isSelected());
    }

    @Test
    public void checkBoxTestTask() {
        /*
         * go to https://the-internet.herokuapp.com/checkboxes
         * locate both checkBoxes web elements
         * verify that checkbox 1 is NOT selected
         * verify that checkbox 2 is selected
         * click check box 1 and check box 2
         * verify that checkbox 1 is selected
         * verify that checkbox 2 is NOT selected
         */

        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }
}
