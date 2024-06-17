package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class _8_findElements {
    public static void main(String[] args) throws InterruptedException {
        // once test class'i olusurup ilgili ayarlari yapiyoruz
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // ilgili sayfaya gidiyorum
        driver.get("https://www.automationexercise.com/");

        // Category bölumundeki elementleri Locate edelim
         List<WebElement> categoryElementsList=driver.findElements(By.className("panel-title"));

        // Category bölümünde 3 element oldugunu test edelim (CTRL + F) diyince

        int actualSize = categoryElementsList.size();
        int expectedSize = 3;

        if (actualSize==expectedSize){
            System.out.println("Category element testi Passed");
        }else {
            System.out.println("Category element testi Failed");
        }

        // Category isimlerini yazdiralim

        /*
         System.out.println("categoryElementsList = " + categoryElementsList); - YAZDIRILAMAZ bu sekilde

        Normalde bir list direkt yazdirilabilir ama findElements() ile bulunan elementler WebElement oldugundan
        direkt YAZDIRILAMAZ.

        bir for-loop kullanilarak listenin elementleri yazdirilabilir
                */

       for (WebElement eachElement : categoryElementsList){
           System.out.println(eachElement.getText() + " ");
       } // WOMEN MEN KIDS

        Thread.sleep(3000);
        // sayfayi kapatalim
        driver.close();
    }
}
