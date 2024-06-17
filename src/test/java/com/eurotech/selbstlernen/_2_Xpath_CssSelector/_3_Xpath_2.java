package com.eurotech.selbstlernen._2_Xpath_CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class _3_Xpath_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https:the-internet.herokuapp.com/add_remove_elements/");

        // Add Element butonuna basin
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();


        // dekete butonunun görübür oldugunu test edin

        WebElement deleteButtonElementi = driver.findElement(By.xpath("//button[@class='added-manually']"));


        if (deleteButtonElementi.isDisplayed()){
            System.out.println("Delete button testi Passed");
        } else {
            System.out.println("Delete button testi Failed");
        }

        // delete tusuna basin
        Thread.sleep(2000);
        deleteButtonElementi.click();


        //"Add/Remove Elements" yazisinin görünür oldugunu test edin


        WebElement addElementsElementi = driver.findElement(By.xpath("//h3"));
        if (addElementsElementi.isDisplayed()){
            System.out.println("Add/Remove Elements testi Passed");
        } else {
            System.out.println("Add/Remove Elementstesti Failed");
        }
        Thread.sleep(2000);
        driver.close();


    }




}
