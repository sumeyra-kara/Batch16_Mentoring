package com.eurotech.tests.day2_webDriverBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _1_NavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        /*
         * set up a firefox(chrome) driver
         * navigate to https://www.facebook.com/
         * then navigate to https://testrelic.com/
         * then navigate back
         * then navigate forward
         * then refresh page
         * then close driver
         */

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        Thread.sleep(2000);

        driver.navigate().to("https://testrelic.com/");
        Thread.sleep(2000);


        driver.navigate().back(); // gerideki sayfaya gitmek icin
        Thread.sleep(2000);

        driver.navigate().forward(); // ileri sayfaya gitmek icin
        Thread.sleep(2000);

        driver.navigate().refresh(); // sayfayi yenilemek
        Thread.sleep(2000);

        driver.close();
        // driver.quit();


    }
}
