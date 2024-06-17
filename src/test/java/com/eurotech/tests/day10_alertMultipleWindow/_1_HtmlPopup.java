package com.eurotech.tests.day10_alertMultipleWindow;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_HtmlPopup {
    /**
     * navigate to https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html
     * click show alert box
     * verify that ok button can be seen on the popup
     * take the text on popup and print it (I am a fake alert box!)
     * then click on ok at the popup
     * verify that ok button cannot be seen
     */
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
    public void htmlPopup() {
        driver.get("https://testpages.herokuapp.com/styled/alerts/fake-alert-test.html");
        WebElement fakeAlert = driver.findElement(By.id("fakealert"));
        fakeAlert.click();
        WebElement okElement = driver.findElement(By.id("dialog-ok"));
        Assert.assertTrue(okElement.isDisplayed());

        WebElement text = driver.findElement(By.id("dialog-text"));
        System.out.println("text.getText() = " + text.getText());

        okElement.click();
        Assert.assertFalse(okElement.isDisplayed());
    }

    @Test
    public void htmlPopupTask() {
        /** zor
         * go to http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437
         * click on confirm button
         * click on yes at the popup window
         * make verification with confirmed popup
         */
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");
        WebElement confirmElement = driver.findElement(By.xpath("//button[@id='j_id_7w:j_id_7y']"));
        confirmElement.click();
        WebElement yes = driver.findElement(By.xpath("//button[@id='j_id_7w:j_id_82']"));
        yes.click();

    }
}
