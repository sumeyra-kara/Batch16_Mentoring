package com.eurotech.tests.day12_Waits;
import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _2_Task {
    /*
     * navigate to https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html
     * locate all buttons to a web element list (start, one, two, three) (findElements)
     * Let's click the buttons respectively
     * after the click to  the last button : "All Buttons Clicked" message should be seen at the page.
     * Note: Do not use Thread.sleep(), just use dynamic waits
     *  https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html sayfasına gidelim
     *  bütün butonları bir list'e alalım (start, one, two, three) (findElements)
     *  butonlara sırasıyla tıklayalım
     *  son butona tıklandıktan sonra "All Buttons Clicked" mesajının ekrana geldiğini text ile doğrulayalım.
     *  Not: Thread.sleep() metodunu kullanmayalım sadece dinamik yani akıllı wait kullanalım...
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
         driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        WebElement start = driver.findElement(By.xpath("//button[@id='button00']"));
        WebElement one = driver.findElement(By.xpath("//button[@id='button01']"));
        WebElement two = driver.findElement(By.xpath("//button[@id='button02']"));
        WebElement three = driver.findElement(By.xpath("//button[@id='button03']"));
        List<WebElement> clickButton  = new ArrayList<>();
        clickButton.add(start);
        clickButton.add(one);
        clickButton.add(two);
        clickButton.add(three);

        for (WebElement button : clickButton){
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        }
        WebElement buttonmessage = driver.findElement(By.id("buttonmessage")); // bu mesaj degisiyor
        System.out.println("buttonmessage.getText() = " + buttonmessage.getText());
        String expectedMessage = "All Buttons Clicked";
        String actualMessage = buttonmessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
