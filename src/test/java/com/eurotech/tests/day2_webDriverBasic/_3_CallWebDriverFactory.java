package com.eurotech.tests.day2_webDriverBasic;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.WebDriver;

public class _3_CallWebDriverFactory {
    /*
     * set up a chrome driver with WebDriverFactory
     * navigate to https://tr-tr.facebook.com/
     * verify that the url is correct
     */

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactor.getDriver("chrome");

         driver.get("https://tr-tr.facebook.com/");

         WebDriverFactor.wait(2);

         String actualUrl = driver.getCurrentUrl();
         String expectedUrl = "https://tr-tr.facebook.com/";

         if (actualUrl.contains(expectedUrl)){
             System.out.println("passed");
         } else {
             System.out.println("failed");
         }


         driver.close();
        
    }

}
