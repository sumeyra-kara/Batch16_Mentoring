package com.eurotech.tests.day10_alertMultipleWindow;

import com.beust.ah.A;
import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _2_Js_Alerts {
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
    public void jsAlert() {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click For Js Alert button
         * create an alert object
         * take text on the alert button and print it
         * click on OK button by using alert object
         * verify that "You successfully clicked an alert" text is seen
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        WebDriverFactor.wait(2);
        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String actualText = result.getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void jsAlertSendKeysTest() {
        /**
         * navigate to https://the-internet.herokuapp.com/javascript_alerts
         * click on click  JS Prompt button
         * create an alert object
         * take text on the alert button and print it
         * send "Ahmet Ay" text to the bar which is on the alert
         * click on OK button by using alert object
         * verify that "You entered: Ahmet Ay" text is seen and verify the correction
         */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        WebDriverFactor.wait(2);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        jsPrompt.click();
        WebDriverFactor.wait(2);

        System.out.println("alert.getText() = " + alert.getText());
        alert.sendKeys("Ahmet Ay");
        WebDriverFactor.wait(2);
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        String actualText = result.getText();
        String expectedText = "You entered: Ahmet Ay";
        Assert.assertEquals(actualText,expectedText);
    }

    @Test
    public void jsAlerttask() throws InterruptedException {
        /**
         * navigate to https://testpages.herokuapp.com/styled/alerts/alert-test.html
         * click alert box
         * then take message on the js popup and print it
         * accept alert
         */
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
        WebElement  alertBox = driver.findElement(By.id("alertexamples"));
        alertBox.click();
        String alertBoxText = driver.switchTo().alert().getText();
        System.out.println("text = " + alertBoxText); //  I am an alert box!
        driver.switchTo().alert().accept();

        /**
         * click show confirm box
         * then take message on the js popup and print it
         * dismiss alert
         * verify that you clicked cancel button (Alınan mesajın Cancel içerdiğini doğrula)
         */
        WebElement confirmBox = driver.findElement(By.id("confirmexample"));
        confirmBox.click();
        String confirmBoxText = driver.switchTo().alert().getText();
        System.out.println("confirmBoxText = " + confirmBoxText);
        driver.switchTo().alert().dismiss();

        WebElement confirmMessage = driver.findElement(By.id("confirmexplanation"));
        String actualMessage = confirmMessage.getText();
        String expectedMessage = "Cancel";
        Assert.assertTrue(actualMessage.contains(expectedMessage));


        /**
         * click show prompt box
         * then take message on the js popup and print it
         * send Ahmet to the popup box
         * accept alert
         * verify that Ahmet is sent to the box.
         */

        WebElement promptBox = driver.findElement(By.id("promptexample"));
        promptBox.click();
        String promptBoxText = driver.switchTo().alert().getText();
        System.out.println("promptBoxText = " + promptBoxText); //  I prompt you

        driver.switchTo().alert().sendKeys("Ahmet");
        driver.switchTo().alert().accept();

        WebElement promptMessage = driver.findElement(By.id("promptreturn"));
        String actualText = promptMessage.getText();
        Assert.assertTrue(actualText.contains("Ahmet"));
        System.out.println(promptMessage.getText());


    }
}
