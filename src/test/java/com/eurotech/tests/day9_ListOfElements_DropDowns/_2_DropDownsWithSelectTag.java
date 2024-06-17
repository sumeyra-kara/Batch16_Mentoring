package com.eurotech.tests.day9_ListOfElements_DropDowns;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

public class _2_DropDownsWithSelectTag {
    /*
     * Select Menu
     * go to https://demoqa.com/select-menu
     * locate Old Style Select Menu (dropdown menu)
     * get all colorsOptions(web elements) as a list
     * verify that the number of webElement is 11
     * click (select) green
     * verify that the selected option's text is 'Green'
     */

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() {
       // driver.close();
    }
    @Test @Ignore
    public void dropDownWithSelect(){
        driver.get("https://demoqa.com/select-menu");
        WebElement dropDownElements = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(dropDownElements);

        List<WebElement> options = select.getOptions();
        System.out.println("options.size() = " + options.size()); // renklerin sayisini verir
        Assert.assertEquals(options.size(),11);

        //Green'i secelim
        options.get(2).click();
        WebDriverFactor.wait(2);

        // listeden Purple olani secelim
        select.selectByVisibleText("Purple");

        // 3. sirada olani secelim
        select.selectByIndex(2);

        // velue'si 2 olani secelim
        select.selectByValue("2");

        // Green'i tekrar secelim ve test edelim
        select.selectByVisibleText("Green");
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        String actualText = firstSelectedOption.getText();
        String expectedText = "Green";
        Assert.assertEquals(actualText,expectedText);

    }
    @Test
    public void amazonTest(){
        /* guzel
         * navigate to https://www.amazon.com.tr"
         * locate the dropdown menu nearby the search box
         * select the Bebek department by using text then print the department name
         * select the Kitaplar department by using index then print the department name
         * select the Saglik ve Bakim department by using value attribute then print the department name
         * get all options to a list
         * print all departments name
         * get the text of fifth element and verify that the text is Books
         */
        driver.navigate().to("https://www.amazon.com.tr");
        driver.manage().window().maximize();

        WebElement cookies = driver.findElement(By.id("sp-cc-rejectall-link"));
        cookies.click();
        WebDriverFactor.wait(3);

        WebElement dropDownElementi  = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownElementi);
        dropDownElementi.click();
        select.selectByVisibleText("Bebek");
        WebDriverFactor.wait(2);
        select.selectByIndex(9);
        WebDriverFactor.wait(2);
        select.selectByValue("search-alias=hpc");

        //get all options to a list
        //print all departments name
        List<WebElement> options = select.getOptions();
        for (WebElement list : options){
            System.out.println("list = " + list.getText());
            System.out.println("list = " + list);
        }
        System.out.println("options.get(5).getText() = " + options.get(5).getText());
        String actualText = options.get(5).getText();
        String expectedText = "Kitaplar";
       // Assert.assertEquals(actualText,expectedText);



    }
}
