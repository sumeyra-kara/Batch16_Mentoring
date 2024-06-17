package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _6_Locators_findElement {

    // 1-- Selenium LOCATORS(konum belirleyici,tarif edici), web sayfasındaki web öğelerini tanımlamak için kullanılır.
    // 2-- Selenium’da; metin kutuları, onay kutuları, linkler, radyo butonları, liste kutuları ve diğer tum web
    //     öğeler üzerinde eylemler gerçekleştirmek için LOCATORS’a ihtiyacımız vardır.
    // 3-- Konum belirleyiciler bize web elementleri tanımlamada yardımcı olur.
    // 4-- Web Elementlerine ulasmak icin tag veya bazi attribute’lerin kullanildigi 6 adet locators bulunur,
    //      bunlarla ulasilamayan webelementleri icin ozel olarak tanimlanan Xpath ve css locator’lari kullanilir.

    public static void main(String[] args) throws InterruptedException {

        // amazon anasayfaya gidip,
        // arama kutusununa nutella yazdirip, enter tusuna basarak arama yapin

        //önce zorunlu adimlari yapiyorum
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon sayfasina gidiyoruz
        driver.get("https://www.amazon.de/");
        /*
            Test otomasyonu yaparken bir web elementi kullanmak istersek 2 seye ihtiyacimiz vardir
            1- o web elementi benzersiz olarak tarif edebilecegimiz bir locator
            2- bu locatori söyledigimizde bize web elementi bulup getirecek method

            ornegin; amazon sitesindeki arama kutusunun unique tarif edici olarak
            id = "twotabsearchtextbox" kullanabiliriz
         */

        WebElement aramaKutusuElementi =driver.findElement(By.id("twotabsearchtextbox"));
        //data türü      objenin adi   assignment
        // findElement :  webelementibulan method  By : webelementi bulacagimiz locator'in türünü buldugumuz method
        // twotabsearchtextbox  :  unique tariif icin id attribut degeri#

        /*
        findElement() methodu verdigimiz locator türü ve o locator icin verdigimiz degere göre webelement'i arar.

        locator icin verdigimiz deger hataliysa veya locator stratejisinde hata yaptiysak aranan web elementi
        implicitlyWait olarakk tanimladigimiz maximum sure boyunca arar.
        Bulamadigi icin "NoSuchElementException" firlatir ve kodlarin kalanini calistirmaz
         */

        aramaKutusuElementi.sendKeys("Nutella"); // arama tusuna nutella yazdirir
        // istenen webelement'e istenen yaziyi gönderir

        aramaKutusuElementi.submit(); // Web element ile islem yaparken ENTER tusuna basma islemini yapar.


        Thread.sleep(3000);
        driver.close();





    }
}
