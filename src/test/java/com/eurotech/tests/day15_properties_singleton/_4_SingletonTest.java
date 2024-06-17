package com.eurotech.tests.day15_properties_singleton;

import com.eurotech.utilities.Driver;
import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class _4_SingletonTest {

    @Test
    public void test() {
       // WebDriver driver = WebDriverFactor.getDriver("chrome");// eski sistemde yaptigimiz
        WebDriver driver = Driver.get();// eski sistemde yaptigimiz
        driver.get("https://www.amazon.com.tr");
    }
    @Test
    public void test2() {
        //WebDriver driver = WebDriverFactor.getDriver("chrome");// eski sistemde yaptigimiz
        WebDriver driver = Driver.get();
        driver.get("https://www.google.com.tr");
        Driver.closeDriver();
    }
}
