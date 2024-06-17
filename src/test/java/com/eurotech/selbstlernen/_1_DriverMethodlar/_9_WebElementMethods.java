package com.eurotech.selbstlernen._1_DriverMethodlar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _9_WebElementMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfasina gidip, arama kutusunu locate edelim
        driver.get("https://www.amazon.de/");

        WebElement aramaKutusuElememti = driver.findElement(By.id("twotabsearchtextbox"));
        System.out.println(aramaKutusuElememti.isDisplayed()); // true - Web element gorunuyor ise true, yoksa false döner
        System.out.println(aramaKutusuElememti.isEnabled()); // true- Web Element erisilebilir mi diye bakar?
        // System.out.println(aramaKutusuElememti.isSelected()); -- Web element secili ise true, yoksa false döner

        aramaKutusuElememti.click(); // Webelement'e click yapar
        aramaKutusuElememti.submit(); // Islem yaparken ENTER tusuna basma islemi yapar

        // bir elementin uzerinde yazi varsa onu bize getirir-- getText();
        System.out.println("aramaKutusuElememti.getText() = " + aramaKutusuElememti.getText());
        // burada olmadigi icin hiclik döndürmüs

        aramaKutusuElememti.sendKeys("Nutella"); // Web Element'e istenen metni yollar
        Thread.sleep(2000);
        aramaKutusuElememti.clear();

        System.out.println("aramaKutusuElememti.getSize() = " + aramaKutusuElememti.getSize()); // (532, 38)
        System.out.println("aramaKutusuElememti.getSize().height = " + aramaKutusuElememti.getSize().height); // 38

        System.out.println("aramaKutusuElememti.getTagName() = " + aramaKutusuElememti.getTagName()); // input

        System.out.println("aramaKutusuElememti.getAttribute() = " + aramaKutusuElememti.getAttribute("class"));
        // nav-input nav-progressive-attribute

        System.out.println("aramaKutusuElememti.getLocation() = " + aramaKutusuElememti.getLocation()); // (396, 10)

        System.out.println("aramaKutusuElememti.getRect().getDimension() = " + aramaKutusuElememti.getRect().getDimension());
        // (532, 38)

        Thread.sleep(3000);
        driver.close();


    }
}
