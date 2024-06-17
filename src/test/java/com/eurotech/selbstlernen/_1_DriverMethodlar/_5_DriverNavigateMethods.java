package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _5_DriverNavigateMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        driver.get("https://mvnrepository.com/");
        Thread.sleep(2000);


        driver.navigate().back(); // acilan sayfadan önceki sayfaya götürür
        Thread.sleep(2000);

        driver.navigate().forward(); // ileriye götürür
        Thread.sleep(2000);

        driver.navigate().refresh(); // sayfayi yeniler

        driver.close();

    }
}
