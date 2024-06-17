package com.eurotech.tests.day14_jsExecuter_FileUpload;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class _1_JsExecuter {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        //driver.close();
    }

    @Test
    public void clickWithJs() {
        /*
         * navigate to https://www.amazon.com.tr/
         * accept cookies if any
         * click Amazon Science link with js executor
            */
        driver.get("https://www.amazon.com.tr/");
        WebElement cookies = driver.findElement(By.id("sp-cc-rejectall-link"));
        cookies.click();

        WebElement amazonScience = driver.findElement(By.linkText("Amazon Science"));
        amazonScience.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",amazonScience);

    }

    @Test
    public void typeWithJs() {
        /*
         * go to https://the-internet.herokuapp.com/dynamic_controls
         * send "Hello World!" to the disabled box with js executor

         * note : ask google--> how to sendKeys using JSExecutor
         */
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement text = driver.findElement(By.xpath("//button[text()='Enable']/../input"));
        String textBox = "Hello World!";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+ textBox +"';", text);
    }

    @Test
    public void test() {
        /*
         * go to https://www.amazon.com.tr/"
         *  accept cookies if any
         * make scroll down and up
         * //js.executeScript("arguments[0].scrollIntoView();",element); ---- asagi dogru kaydrima
         */
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();
        WebElement cookies = driver.findElement(By.id("sp-cc-rejectall-link"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        cookies.click();
        for (int i = 0; i < 5; i++) {
            WebDriverFactor.wait(1);
            js.executeScript("window.scrollBy(0,500)"); //scroll down
        }
        for (int i = 0; i < 5; i++) {
            WebDriverFactor.wait(1);
            //
            js.executeScript("window.scrollBy(0,-500)"); //scroll down
        }

        WebElement amazonScience = driver.findElement(By.linkText("Amazon Science"));
        js.executeScript("arguments[0].scrollIntoView();",amazonScience);
        WebDriverFactor.wait(2);
        WebElement moda = driver.findElement(By.linkText("Moda"));

        js.executeScript("arguments[0].scrollIntoView();",moda);
        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()",amazonScience);





    }
}
