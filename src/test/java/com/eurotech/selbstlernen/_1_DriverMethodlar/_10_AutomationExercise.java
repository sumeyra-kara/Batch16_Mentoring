package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class _10_AutomationExercise {

    public static void main(String[] args) {

        // once ilgili ayarlari yapalim

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // ilgili adrese gidelim
        driver.get("https://www.automationexercise.com/");

        // sayfada 147 adet link oldugunu test edin
        List<WebElement> sayfadakiLinkElementleri = driver.findElements(By.tagName("a"));

        int actualLinkSayisi = sayfadakiLinkElementleri.size();
        int expectedLinkSayisi = 147;

        if (actualLinkSayisi==expectedLinkSayisi){
            System.out.println("link sayisi testi passed");
        } else {
            System.out.println("link sayisi testi failed");
        }

        // Products linkine tiklayin
        WebElement productsLinkElementi = driver.findElement(By.partialLinkText(" Products"));
        productsLinkElementi.click();

        // special offer yazisinin göründügünü test edin

        WebElement specialOfferElementi = driver.findElement(By.id("sale_image"));

        if (specialOfferElementi.isDisplayed()){
            System.out.println("speacial offer testi passed");
        } else {
            System.out.println("speacial offer testi failed");
        }

        // sayfayi kapatin
         driver.close();


    }


}
