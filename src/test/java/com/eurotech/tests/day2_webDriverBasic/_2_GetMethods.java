package com.eurotech.tests.day2_webDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_GetMethods {
    public static void main(String[] args) {
        /*
         * set up a chrome driver
         * navigate to https://www.hepsiburada.com/
         * get title and get url get page source code
         * verify that title, url and Page source codes  contain "hepsiburada"
         */

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.hepsiburada.com/");

        String actualTitle = driver.getTitle();
        String actualCurrentUrl = driver.getCurrentUrl();
        String actualPageSource = driver.getPageSource();

        String expectedData = "hepsiburada";

        if (actualTitle.toLowerCase().contains(expectedData) && actualCurrentUrl.toLowerCase().contains(expectedData) && actualCurrentUrl.toLowerCase().contains(expectedData)){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        System.out.println("actualTitle = " + actualTitle); // Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com
        System.out.println("actualCurrentUrl = " + actualCurrentUrl); // https://www.hepsiburada.com/

        driver.close();
    }
}
