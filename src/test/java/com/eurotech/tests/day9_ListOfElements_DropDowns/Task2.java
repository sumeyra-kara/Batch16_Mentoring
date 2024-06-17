package com.eurotech.tests.day9_ListOfElements_DropDowns;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task2 {
    /*
    //form[@method='post']//input | //textarea
    //form[@method='post']//input | //input[@type='submit']
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
    public void testName() {


    }
}
