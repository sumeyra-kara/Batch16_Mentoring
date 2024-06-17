package com.eurotech.selbstlernen._2_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class _1_Locator {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon sayfasina gidelim
        driver.get("https://www.amazon.de/");

        // Arama Kutusuna "city bike" yazip aratin
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElementi.sendKeys("city bike" + Keys.ENTER);

        // Görüntülenen sonuclarin sayisini yazdirin
        WebElement aramaSonucuElementi = driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucuElementi.getText());
        // 1-16 von 729 Ergebnissen oder Vorschlägen für "city bike"

        // Listeden ilk ürünun resmine tiklayin

        List<WebElement> urunResimElementleriList = driver.findElements(By.className("s-image"));
        urunResimElementleriList.get(0).click();

        Thread.sleep(2000);
        // driver.close();
    }
}
