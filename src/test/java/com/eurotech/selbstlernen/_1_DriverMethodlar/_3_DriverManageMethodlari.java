package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _3_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");

        System.out.println("Baslangictaki konum : " + driver.manage().window().getPosition()); // (9, 9)
        System.out.println("Baslangictaki boyut " + driver.manage().window().getSize()); // (1051, 798)

        driver.manage().window().maximize();
        // biz genelde bir teste baslamadan önce window'u maximize yapmayi tercih ederiz
        driver.manage().window().fullscreen(); // tam ekran
        driver.manage().window().minimize();

        // pencereyi istedigimiz boyut ve konuma getirelim
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        /*
        ImplicitlyWait bir web Sayfasi acilincaya kadar veya aradigimiz elementler bulununcaya kadar
        driver'in bekleyecegi maximum sureyi belirler
         */


        Thread.sleep(2000);
        driver.close();
    }
}
