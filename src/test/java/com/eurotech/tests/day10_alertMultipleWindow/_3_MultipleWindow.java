package com.eurotech.tests.day10_alertMultipleWindow;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Set;

public class _3_MultipleWindow {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        //driver.quit();
    }

    @Test @Ignore
    public void multipleWindow() {
        /**
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click Basic Ajax in new page
         * switch to new opened page
         * verify that the page title is "Test Page For Basic Ajax Example"
         * verify that the new page's url is different
         */

        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement basicAjax = driver.findElement(By.id("gobasicajax"));
        basicAjax.click();


        String erstewindowHandle = driver.getWindowHandle();
        System.out.println("erstewindowHandle = " + erstewindowHandle);
        Set<String> allwindwosHandles = driver.getWindowHandles();
        for (String handle : allwindwosHandles){
            if (!handle.equals(erstewindowHandle)){
                driver.switchTo().window(handle);
                break;
            }
        }

        String actualTitle = driver.getTitle();
        String expectedTtitle = "Test Page For Basic Ajax Example";
        Assert.assertEquals(actualTitle,expectedTtitle);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl  ="https://testpages.herokuapp.com/styled/windows-test.html";
        Assert.assertNotEquals(expectedUrl, actualUrl);
    }

    @Test
    public void multipleWindow2() {
        /**
         *navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         * click all three links
         * switch to the page whose title is "Test Page For Element Attributes"
         * verify that the page title
         * verify that the new page's url is different
         */
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        WebElement basicAjax = driver.findElement(By.id("gobasicajax"));
        basicAjax.click();
        WebElement b = driver.findElement(By.id("goattributes"));
        b.click();
        WebElement c = driver.findElement(By.id("goalerts"));
        c.click();

        Set<String> allTabs = driver.getWindowHandles();
        System.out.println("allTabs = " + allTabs);
        String expectedTitle = "Test Page For Element Attributes";

        for (String handle : allTabs){
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(expectedTitle)){
                break;
            }
        }

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://testpages.herokuapp.com/styled/windows-test.html";
        Assert.assertNotEquals(actualUrl,expectedUrl);
    }

    @Test
    public void task() {
        /**
         * https://the-internet.herokuapp.com/windows sayfasını açın
         * "Click Here" linkine tıklayın
         * yeni açılan pencereye geçin
         * yeni açılan sayfada "New Window" başlığının olduğunu doğrulayın.
         * yeni açılan pencerenin title ve url'sini alıp yazdırın. (isterseniz bunları kullanarak verification yapabilirsiniz)
         */


        driver.get("https://the-internet.herokuapp.com/windows");
        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        String ilkSayfaWindowHandle =  driver.getCurrentUrl();
        String ikinciSayfaWindowHandle = "";

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            if (!each.equals(ilkSayfaWindowHandle)){
                ikinciSayfaWindowHandle=each;
            }
        }


        driver.switchTo().window(ikinciSayfaWindowHandle);
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        String expectedText = "New Window";
        String actualText = newWindowText.getText();
        Assert.assertEquals(actualText,expectedText);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        System.out.println("driver.getTitle() = " + driver.getTitle());


    }
}
