package com.eurotech.tests.day1_intro;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_WindowMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");

        // pencereyi tam sayfa yapmak icin
        //driver.manage().window().maximize();

        //driver.manage().window().fullscreen(); // tam ekran

        // get the position of the window- pencerenin koordinatini alalim
        Point position = driver.manage().window().getPosition();
        System.out.println("position = " + position); // position = (9, 9)


        // how to change screen with window- penreceyi diger ekrana alalim
        driver.manage().window().setPosition(new Point(+1000,0));
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // pencerenin ebatlarini alalim

        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;

        System.out.println("width = " + width); // width = 1552
        System.out.println("height = " + height); // height = 832

        Dimension size = driver.manage().window().getSize();
        System.out.println("size = " + size); // size = (1552, 832)

        // pencerenin ebatlarini belirleyelim
        driver.manage().window().setSize(new Dimension(100,500));

        Thread.sleep(2000);
        driver.close();

    }
}
