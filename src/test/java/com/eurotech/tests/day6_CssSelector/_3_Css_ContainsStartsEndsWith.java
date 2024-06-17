package com.eurotech.tests.day6_CssSelector;


import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class _3_Css_ContainsStartsEndsWith {
    public static void main(String[] args) {
        /**
         * class task
         * navigate to http://www.eurotech.study/
         * click cookies button css contains (*)
         * click login button with css starts-with (^)
         * send your email to email box with css ends-with ($)
         * send your password to password box with css parent to child (>)
         * click login btn with css parent to grandson (space)
         * -----------------------------
         * [attribute*='value'] (contains)
         * tagName[attribute*='value'] (contains)
         *
         * [attribute^='firstPartOfValue'] (starts with)
         * tagName[attribute^='firstPartOfValue'] (starts with)
         *
         * [attribute$='lastPartOfValue'] (ends-with)
         * tagName[attribute$='lastPartOfValue'] (ends-with)
         *
         * xpath '/'  --> parent to child
         * css   '>'  --> parent to child
         * xpath '//' --> parent to grandson
         * css   ' '  --> parent to grandson  (space-boşluk)
         *   */

        WebDriver driver = WebDriverFactor.getDriver("chrome");
        driver.get("http://www.eurotech.study/");

        WebElement cookies = driver.findElement(By.cssSelector("[aria-label*='Accept cookies']"));
        cookies.click();
        WebElement loginButton = driver.findElement(By.cssSelector("a[href='/login']"));
        loginButton.click();
        WebDriverFactor.wait(2);


        WebElement emailButton = driver.findElement(By.cssSelector("#loginpage-input-email"));
        emailButton.sendKeys("sumeyrakara93@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("#loginpage-form-pw-container>input"));
        password.sendKeys("1224532");

        WebElement clickLogin = driver.findElement(By.cssSelector("#loginpage-form-btn"));
        clickLogin.click();

        driver.close();


        /*
        WebElement cookies = driver.findElement(By.cssSelector("[id*='confir']"));
        cookies.click();
        WebDriverFactory.wait(2);

        driver.findElement(By.cssSelector("[class^='btn btn-p']")).click(); //lazy way

        driver.findElement(By.cssSelector("[name$='ail']")).sendKeys("aaaaa@aaa.com"); //lazy way

        WebElement passwordBox = driver.findElement(By.cssSelector("form>#signuppage-form-pw1-container>input"));
        passwordBox.sendKeys("123456");
        WebDriverFactory.wait(2);

        WebElement loginBtn = driver.findElement(By.cssSelector("section input[type='submit']"));
        loginBtn.click();

        WebDriverFactory.wait(2);
        driver.close();
         */


    }
}
