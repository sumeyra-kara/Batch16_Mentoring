package com.eurotech.tests.day14_jsExecuter_FileUpload;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ServiceLoader;

public class _2_TaskJs {

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
    public void test() {
        // navigate to https://www.krafttechexlab.com/forms/elements
        driver.get("https://www.krafttechexlab.com/forms/elements");
        driver.manage().window().maximize();

        // type in Text element with js "Batch 16 was here."
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement text = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
        String textBox = "Batch 16 was here.";
        js.executeScript("arguments[0].value='"+ textBox +"';", text); // bir yere yazi göndermek icin

        // scroll 1000 px down
        js.executeScript("window.scrollBy(0, 1000)"); // scroll yapmak icin

        // change the Range position(with Actions)
        Actions actions = new Actions(driver);
        WebElement range = driver.findElement(By.xpath("//input[@id='customRange1']"));
        // actions.dragAndDropBy(range,80,0).perform(); // x,y
        // actions.moveToElement(range).moveByOffset(300,0).click().perform();
        actions.clickAndHold(range).moveByOffset(300, 0).release().build().perform();
        //js.executeScript("arguments[0].value = '75'", range);

        // change the Disabled Range position
        WebElement disableRange = driver.findElement(By.xpath("//input[@id='disabledRange']"));
        js.executeScript("arguments[0].value = '3'", disableRange);

        // scroll to the Number label
        WebElement numberElement = driver.findElement(By.xpath("//label[text()='Number']"));
        js.executeScript("arguments[0].scrollIntoView();",numberElement); // istenen elemente scroll yapmak icin
        WebDriverFactor.wait(3);

        // change the color from blue to red
        WebElement color = driver.findElement(By.xpath("//input[@name='color']"));
        //js.executeScript("arguments[0].style.color = 'red';", color);
        String newColor = "#E30D0D"; // Örnek olarak kırmızı rengi seçelim
        js.executeScript("arguments[0].value = arguments[1]", color, newColor);
        WebDriverFactor.wait(3);

        // type in "Batch 16 was also here." to disable text area
        WebElement textArea = driver.findElement(By.xpath("//div[@class='col-sm-10']/textarea"));
        String textareaText ="Batch 16 was also here.";
        js.executeScript("arguments[0].value='"+ textareaText +"';", textArea); // istenen yere bir metin göndermek icin

        // select the Disabled Radio 3 button -------
        WebElement button3 = driver.findElement(By.xpath("//label[text()='Disabled Radio 3']"));
        js.executeScript("arguments[0].click();",button3); //button3.click();

        // scroll to the submit button
        WebElement submitButtonText = driver.findElement(By.xpath("//label[text()='Submit Button']"));
        js.executeScript("arguments[0].scrollIntoView();",submitButtonText);

        // scroll again to the number label
        // yukarida locate etmistik
        js.executeScript("arguments[0].scrollIntoView();",numberElement);

        // scroll to the submit button and click on it
        WebElement submitButton = driver.findElement(By.xpath("//button[@name='submit']"));
        js.executeScript("arguments[0].scrollIntoView();",submitButton);
        actions.keyDown(Keys.CONTROL).click(submitButton).keyUp(Keys.CONTROL).build().perform();
        // klavye ile de islem yaparken keyDown ve keyUp methodlari kullanilir.

        //  take the new page title and url
        //  verify that the page title contains "Kraft"
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitle = "Kraft";
        //String actualTitle = driver.getTitle();
        String actualTitle=js.executeScript("return document.title;").toString();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //  verify that the page url contains "kraft"
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        String expectedUrl  = "kraft";
        String currentURL=js.executeScript("return document.URL;").toString();
        //String actualUrl  =driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains(expectedUrl));

        // driver.quit();
    }

    /*
    *****klavye ile yapilabilecek islemler****
     keyDown ( ) : Klavyede tuşa basma işlemidir.
     keyUp ( )   : Klavyede tuşu serbest bırakma işlemidir.
     keysend ()  : klavyede bir yere yazi gönderme islemidir.

     */
}
