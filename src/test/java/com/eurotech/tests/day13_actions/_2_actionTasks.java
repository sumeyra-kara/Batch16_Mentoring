package com.eurotech.tests.day13_actions;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class _2_actionTasks {
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
    public void hoverTaskTest() {
        /**
         * go to https://the-internet.herokuapp.com/hovers -- resimleri hover edicez
         * locate all users (image on the page) with findElements() -- altinda metinler cikiyor
         * hover over all of them and verify that "name:user1-2-3" is displayed
         * if any time issues solve them with implicitly or explicitly waits
         */
        driver.get("https://the-internet.herokuapp.com/hovers");

        List<WebElement> images = driver.findElements(By.xpath("//img[@alt='User Avatar']"));
        for (WebElement image: images){
            action.moveToElement(image).perform();
        }
    }

    @Test
    public void dragAndDropTask() {
        /**
         * go to https://demoqa.com/droppable
         * take "Drag me" and drop it "Drop here" section
         * verify that the "Dropped!" message is displayed (make text verification)
         */
        driver.get("https://demoqa.com/droppable");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable,droppable).perform();

        WebElement droppedText = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String actualMessage =droppedText.getText();
        String expectedMessage = "Dropped!";
        Assert.assertTrue(droppedText.isDisplayed());
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @Test
    public void clickTaskTest() {
        /**
         * navigate to https://skill-test.net/right-click-test
         * make right click to the Start box and wait three seconds
         * make normal click on Reset box (use actions)
         */
        driver.get("https://skill-test.net/right-click-test");
        WebElement cookies = driver.findElement(By.xpath("(//p[@class='fc-button-label'])[1]"));
        cookies.click();
        WebElement start = driver.findElement(By.id("clicker"));
        WebElement reset = driver.findElement(By.id("reset"));
        action.contextClick(start).perform();
        action.pause(Duration.ofSeconds(3)).perform();
        action.click(reset).perform();
    }

    @Test
    public void fillingFormTask() {
        /**
         * go to https://www.krafttechexlab.com/login
         * send your credentials to related boxes and then click login button
         * click my profile
         * click on Add Experience link
         * fill form with action class
         * verify the success message after submitted the form
         */
        driver.get("https://www.krafttechexlab.com/login");
        WebElement email = driver.findElement(By.id("email"));
        action.click(email)
                .sendKeys("skara@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("001309Sumve")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        WebElement profil = driver.findElement(By.xpath("//span[@class='d-none d-md-block dropdown-toggle ps-2']"));
        profil.click();

        WebElement myProfile = driver.findElement(By.xpath("//span[text()='My Profile']"));
        myProfile.click();

        WebElement addExperience = driver.findElement(By.xpath("(//button[text()='Add Experience'])[1]"));
        addExperience.click();

        WebElement jobTitle = driver.findElement(By.xpath("//input[@placeholder='Job Title *']"));
        action.click(jobTitle).sendKeys("Dr.")
                .sendKeys(Keys.TAB)
                .sendKeys("Akdeniz Uni.")
                .sendKeys(Keys.TAB)
                .sendKeys("Antalya")
                .sendKeys(Keys.TAB)
                .sendKeys("21011990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("21012022")
                .sendKeys(Keys.TAB)
                .sendKeys("gute Arbeit")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        
    }
}
