package com.eurotech.selbstlernen._2_Xpath_CssSelector;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _6_CssSelectorPractice {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.de/");

        // Browser'i tam sayfa yapalim
        driver.manage().window().maximize();

        // Browser'i refresh yapalim
        driver.navigate().refresh();

        // sayfa basliginin "Spen less" ifadesi icerdigini test edin
        String actualIcreik = driver.getTitle();
        String expectedIcerik = "Spen less";

        if (actualIcreik.contains(expectedIcerik)){
            System.out.println("Title test passed");
        } else {
            System.out.println("Title test failed");
        }

        // Gift Cards sekmesine basin

        //driver.findElement(By.xpath("(//a[@class='nav-a'])[2]")).click();


        // Best Seller Bölümunden ilk urunu tiklayin

        // Gift card details'den 25 $'i secin

        // Ürün ücretinin 25$ oldugunu test edin



        // drive.close();

    }
}
