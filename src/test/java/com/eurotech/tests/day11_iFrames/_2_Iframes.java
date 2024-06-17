package com.eurotech.tests.day11_iFrames;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_Iframes {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        //driver.close();
    }

    @Test
    public void iFrameWithIndexTest() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/iframes-test.html
         * switch to first frame by index
         * take the "iFrame" heading and print it
         * return to main html  (default content)
         * switch to second frame by index
         * take the "Nested Page Example" heading and print it
         */

        driver.get("https://testpages.herokuapp.com/styled/iframes-test.html");
        driver.switchTo().frame(0);
        WebElement title1 = driver.findElement(By.xpath("//h1[text()='iFrame']"));
        System.out.println("title1.getText() = " + title1.getText());
        driver.switchTo().parentFrame();
        WebElement secondIFrame = driver.findElement(By.cssSelector("[src='frames/frames-header.html']"));
        driver.switchTo().frame(1);

        WebElement title2 = driver.findElement(By.tagName("h1"));
        System.out.println("title2.getText() = " + title2.getText());
        driver.switchTo().defaultContent();

        WebElement title0 = driver.findElement(By.tagName("h1"));
        System.out.println("title0.getText() = " + title0.getText());
    }

    @Test
    public void iFrameTest() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/frames/frames-test.html
         * switch to top frame by name attribute
         * take the "Nested Frames Example" heading and print it
         * return to main html
         * switch to left frame by name attribute --
         * take the "Left" heading and print it
         * return to main html
         * switch to middle frame by index ---
         * take the "Middle" heading and print it
         * return to main html
         * switch to right frame by web element
         * take the "Right" heading and print it
         * return to main html
         * switch to footer frame by index
         * take the "EvilTester.com" link text and print it
         */
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        driver.switchTo().frame("top");
        WebElement topTitle = driver.findElement(By.tagName("h1"));
        System.out.println("topTitle.getText() = " + topTitle.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame("left");
        WebElement leftTitle = driver.findElement(By.tagName("h1"));
        System.out.println("leftTitle.getText() = " + leftTitle.getText());
        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        WebElement middleTitle = driver.findElement(By.xpath("//*[text()='Middle']"));
        System.out.println("middleTitle.getText() = " + middleTitle.getText());
        driver.switchTo().defaultContent();

        WebElement rightElement = driver.findElement(By.xpath("//*[@name='right']"));
        driver.switchTo().frame(rightElement);

        WebElement rightTitle = driver.findElement(By.tagName("h1"));
        System.out.println("rightTitle.getText() = " + rightTitle.getText());
        driver.switchTo().parentFrame();

        driver.switchTo().frame(4);
        WebElement footerLink = driver.findElement(By.linkText("EvilTester.com"));
        System.out.println("footerLink.getText() = " + footerLink.getText());
    }

    @Test
    public void nestedFrame() {
        /**
         * navigate to https://demoqa.com/nestedframes
         * switch to parent frame by id
         * take the "Parent frame" heading and print it
         * switch to child frame by index
         * take the "Child frame" heading and print it
         * switch to main frame related method
         * take the "Nested Frames" heading and print it
         */
        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        WebElement parentTitle = driver.findElement(By.tagName("body"));
        System.out.println("title.getText() = " + parentTitle.getText());

        System.out.println("driver = " + driver);
        driver.switchTo().frame(0);
        WebElement childTitle = driver.findElement(By.tagName("p"));
        System.out.println("childTitle.getText() = " + childTitle.getText());

        driver.switchTo().defaultContent();
        WebElement mainTitle = driver.findElement(By.xpath("//h1"));
        System.out.println("mainTiitle.getText() = " + mainTitle.getText());


    }
}
