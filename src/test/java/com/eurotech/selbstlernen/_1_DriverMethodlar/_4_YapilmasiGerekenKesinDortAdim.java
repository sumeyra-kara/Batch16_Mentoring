package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _4_YapilmasiGerekenKesinDortAdim {
    public static void main(String[] args) {
        /*
        su 4 adim her testin basinda mutlaka yapilmali (selenyum sonuna kadar)
         */


        // 1. driver icin gerekli ayaralamalari yap
        System.setProperty("url","dosya yolu");

        //2. webDriver olustur
        WebDriver driver = new ChromeDriver();

        //3. window`u maximize yap
        driver.manage().window().maximize();

        //4. gecikmeler icin maximum bekleme suresi tanimla
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
}
