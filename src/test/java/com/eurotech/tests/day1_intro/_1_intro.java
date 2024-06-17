package com.eurotech.tests.day1_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_intro {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        driver.close();
    }
}
