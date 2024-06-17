package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_IlkTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/"); // amazon safasina gider

        System.out.println("driver.getTitle() = " + driver.getTitle()); // sayfanin basligini yazdirir

        String actualTitle = driver.getTitle(); // gittigim yerin basligi- gerceklesen deger
        String expectedTitle = "Amazon"; // bize testte istenen,beklenen degerler

        if (actualTitle.contains(expectedTitle)){
            System.out.println("title is passed");
        }else{
            System.out.println("title is failed");
        }

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl()); // sayfa url'si

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";

        if (actualUrl.contains(expectedUrl)){
            System.out.println("url test is passed");
        } else {
            System.out.println("url test is failed");
        }

        System.out.println("driver.getwindowHandle() = " + driver.getWindowHandle()); // sayfanin handle degeri
        // 5EED6E6D88C28C583AE2D35E7EE54FC8

        // safanin HTML kodlarinda "alisveris" kelimesi gectigini test edin
        String actualPageSource = driver.getPageSource();
        String expectedIcerik = "alisveris";

        if (actualPageSource.contains(expectedIcerik)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }


        driver.close();
    }
}
