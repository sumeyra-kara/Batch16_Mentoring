package com.eurotech.tests.day13_actions;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _1_actions {
    WebDriver driver;
    Actions action;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        action=new Actions(driver);
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        //driver.close();
    }


    @Test
    public void hoverOverTest() {
        /**
         * navigate to https://testpages.herokuapp.com/styled/csspseudo/css-hover.html
         * hover over "Hover Para" element
         * get the text which is seen after hover action
         * and verify that the text is "You can see this paragraph now that you hovered on the above 'button'."
         * also verify that the text is displayed (use explicit wait)
         * hover over the "Hover Div" and verify that the text is not displayed anymore. (use explicit wait)
         */

        driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        WebElement hoverpara = driver.findElement(By.id("hoverpara"));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverpara).perform();

        WebElement hoverparaeffectElement = driver.findElement(By.id("hoverparaeffect"));
        String expectedText = "You can see this paragraph now that you hovered on the above 'button'.";
        String actualText = hoverparaeffectElement.getText();
        Assert.assertEquals(expectedText,actualText);
        actions.moveToElement(hoverpara).perform();
        Assert.assertTrue(new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOf(hoverparaeffectElement)).isDisplayed());


        WebElement hoverdivpara = driver.findElement(By.id("hoverdivpara"));
        actions.moveToElement(hoverdivpara).perform();
        Assert.assertTrue(new WebDriverWait(driver,Duration.ofSeconds(4)).until(ExpectedConditions.invisibilityOf(hoverparaeffectElement)));
    }
    @Test
    public void dragAndDropTest() {
        /**
         * go to https://webdriveruniversity.com/Actions/index.html
         * take the "DRAG ME TO MY TARGET!" box and drop it "DROP HERE!" place
         * verify that "Dropped!" text is displayed..(make text correction at the same time)
         */
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        action.dragAndDrop(draggable,droppable).perform();
        //action.moveToElement(draggable).clickAndHold().moveToElement(droppable).pause(2000).release().build().perform();

        WebElement dropHereElement = driver.findElement(By.xpath("//b[text()='Dropped!']"));
        System.out.println("dropHereElement.getText() = " + dropHereElement.getText());
        String actualText = dropHereElement.getText();
        String expectedText ="Dropped!";
        Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue(dropHereElement.isDisplayed());
    }

    @Test
    public void clickWithActionTest() {
        /**
         * navigate to https://skill-test.net/mouse-double-click
         * make double click to the Click box
         * make a normal click to the Click Box (not the middle of element)
         */
        driver.get("https://skill-test.net/mouse-double-click");
        WebElement cookies = driver.findElement(By.xpath("//p[text()='Nicht einwilligen']"));
        cookies.click();

        WebElement clickButton = driver.findElement(By.id("clicker"));
        action.doubleClick(clickButton).perform();
        // action.moveToElement(clickButton).doubleClick().perform(); -- diger yol

        // normal click
        //action.click(clickButton).perform();

        // normal click tiklama yeri tarif ederek
        //action.moveToElement(clickButton,5,6).click().perform();
    }

    @Test
    public void fillingFormWithAction() {
        /**
         * go to http://www.eurotech.study/
         * accept cookies
         * click login
         * send your credentials to related boxes and then click login button
         * sgezer56@gmail.com
         * Sg12345678
         * click on Add Experience link
         * fill form with action class
         * verify the success message after submitted the form
         */
        driver.get("http://www.eurotech.study/");
        WebElement cookies = driver.findElement(By.id("rcc-confirm-button"));
        cookies.click();
        WebDriverFactor.wait(2);

        WebElement loginButton = driver.findElement(By.xpath("//a[text()='Login']"));
        loginButton.click();
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        inputs.get(0).sendKeys("sgezer56@gmail.com");
        inputs.get(1).sendKeys("Sg12345678");
        inputs.get(2).click();

        WebElement addExperience = driver.findElement(By.linkText("Add Experience"));
        addExperience.click();

        WebElement jobTitleElement = driver.findElement(By.id("addexperience-jobtitle-input"));
        action.click(jobTitleElement)
                .sendKeys("Dr.")
                .sendKeys(Keys.TAB)
                .sendKeys("Akdeniz Üni.")
                .sendKeys(Keys.TAB)
                .sendKeys("Antalya")
                .sendKeys(Keys.TAB)
                .sendKeys("21111993")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("02022023")
                .sendKeys(Keys.TAB)
                .sendKeys("nice Job")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
