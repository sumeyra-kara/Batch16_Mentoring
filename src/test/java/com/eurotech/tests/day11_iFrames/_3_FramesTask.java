package com.eurotech.tests.day11_iFrames;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _3_FramesTask {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        // driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        /**
         * navigate to https://the-internet.herokuapp.com/iframe
         * get the text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it
         * Firstly clear the text area  which contains "Your content goes here."
         * And send a new text to the area : "Hello World!"
         * get te text of heading "An iFrame containing the TinyMCE WYSIWYG Editor" and print it again.
         * NOT : frame geçişlerinde id veya name kullanalım.
         */
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement textElement = driver.findElement(By.tagName("h3"));
        System.out.println("textElement.getText() = " + textElement.getText());
        driver.switchTo().frame("mce_0_ifr");
        Thread.sleep(2);
        WebElement yourContentGoesHere = driver.findElement(By.cssSelector("#tinymce>p"));
        yourContentGoesHere.clear();
        yourContentGoesHere.sendKeys("Hello World!");
        driver.switchTo().parentFrame();
        WebElement textElement2 = driver.findElement(By.tagName("h3"));
        System.out.println("textElement.getText() = " + textElement2.getText());
    }
    @Test
    public void test2() {
        /**
         * go to https://the-internet.herokuapp.com/nested_frames
         * verify that the MIDDLE text is seen  -- by name
         * verify that the RIGHT text is seen   -- by index
         * verify that the BOTTOM text is seen  --by index
         * NOT: belirtilmeyen geçişlerde istediğiniz yöntemi kullanabilirsiniz.
         * Framler'de bulunan textler yazdirilacaktir.
         */
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.id("content"));
        System.out.println("middle.getText() = " + middle.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().frame(2);
        WebElement right = driver.findElement(By.tagName("body"));
        System.out.println("right.getText() = " + right.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        WebElement bottom = driver.findElement(By.tagName("body"));
        System.out.println("bottom.getText() = " + bottom.getText());


    }
}
