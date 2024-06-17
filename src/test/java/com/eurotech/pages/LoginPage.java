package com.eurotech.pages;

import com.eurotech.utilities.ConfigReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
        /* Bir page class’i olusturdugumuzda ilk isimiz bir constructor olusturup, pageFactory class’indan
        initElements() method’unu kullanmak olmalidir.
        */
        // Bu ayari constructor icine koyma sebebimiz: page sayfalarina obje olusturularak ulasildigi icin,
        // kim page sayfasini kullanmak isterse, page sayfasindan obje olusturmak icin, constructor calisacak ve
        // bu constructor'in icinde bulunan initElements() gerekli ayari yapmis olacak
    }
    //@FindBy notasyonu test class’larinda kullanacagimiz Web Elementlerini Page sayfasinda locate etmek icin kullanilir
    @FindBy(id = "email")
    public WebElement emailBox;  // WebElement emailBox = Driver.get().findElement(By.id("email")); --- bu bu demek

    @FindBy(id = "yourPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginButton;

    @FindBys({ // and logical
            @FindBy(id = "email"),
            @FindBy(xpath = "//input[@name='email']")
    })
    public WebElement emailBoxWithFindBys;

    @FindAll({ // or logical
            @FindBy(id = "yourPassword"),
            @FindBy(xpath = "//input[@type='password']")
    })
    public WebElement passwordBoxWithFindBys;

    @FindBy(css = "[role='alert']")
    public WebElement wronEmailMessage;


    public void login(String email,String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();
    }
    public void login(){
        emailBox.sendKeys(ConfigReader.get("email"));
        passwordBox.sendKeys(ConfigReader.get("password"));
        loginButton.click();
    }

    public String getWrongEmailMessageText (){
        return wronEmailMessage.getText();
    }


}
