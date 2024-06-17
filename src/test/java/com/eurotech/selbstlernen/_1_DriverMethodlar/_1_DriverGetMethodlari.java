package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        /*
        Selenium 4.7 versiyonu ile kendi driverini sisteme ekledi. kodlar calismaya basladiginda biz driver icin
        yol göstermezsek Selenium kendi driver'ini devreye sokuyor. ama baslangicta driver ayarini aradigi icin
        biraz yavas calisir
        O yuzden su asagidaki yazilmayabilir bu versiyon icin

        System.setProperty("....url...","..dosyayolu..")
         */

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/downloads/"); // www yi yazmasak da olur hata vermez ama https:// yazmazsak hata verir

        Thread.sleep(3000); // 3 sn bekletir

        System.out.println("driver.getTitle() = " + driver.getTitle());
        // bize tittle'i döndürür -- Downloads | Selenium

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        // gidilen url'i döndürür-- https://www.selenium.dev/downloads/

        // System.out.println("driver.getPageSource() = " + driver.getPageSource());
        // gidilen web sayfasinin kaynak kodlarini döndürür

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle()); // 79A557114CD448AA275F0E5B97B830EF
        //acilan her bir pencereye verilen unique hash code degeridir

        System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());
        // eger driver calisirken birden fazla pencere veya tab olusturduysa
        // acilan tüm windowlarin unique hash code'larini bir set olarak döndürür



        driver.close(); // acilan pencereyi kapatir



    }
}
