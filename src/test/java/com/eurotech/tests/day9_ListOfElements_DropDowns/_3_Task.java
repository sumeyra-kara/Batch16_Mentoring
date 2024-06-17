package com.eurotech.tests.day9_ListOfElements_DropDowns;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _3_Task {

/*
 * navigate to https://demo.aspnetawesome.com/
 * locate and click DropdownList (Mango ile başlayan liste)
 * get all option names and print them
 * click potato by index (6) and make verification
 * click again drop down list
 * click rice with its own locator (Rice'ı locate edip tıklayalım.)
 * then make verification
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
    public void dropdownTest() {
        driver.get("https://demo.aspnetawesome.com/");
        WebDriverFactor.wait(2);
        WebElement meyveButton = driver.findElement(By.id("AllMeals-awed"));
        //WebElement meyve = driver.findElement(By.xpath("(//div[@class='o-itsc'])[8]//li"));
        meyveButton.click();
        WebDriverFactor.wait(2);

        WebElement potatoElement = driver.findElement(By.xpath("(//div[@class='o-igit'])[7]"));
        potatoElement.click();
        WebDriverFactor.wait(3);

        meyveButton.click();

        WebElement reisElement = driver.findElement(By.xpath("(//div[@class='o-igit'])[21]//img"));
        reisElement.click();
        WebDriverFactor.wait(1);
        // Assert.assertTrue(reisElement.isEnabled());



    }
}
