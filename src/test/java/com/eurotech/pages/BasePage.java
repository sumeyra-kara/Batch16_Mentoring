package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
   // public abstract void verifyPageTitle();



    @FindBy (xpath = "//span[text()='My Profile']")
    public WebElement myProfile;


    public void menu(String tabName, String modulName){
        WebElement tab = Driver.get().findElement(By.xpath("//span[text()='"+tabName+"']"));
        tab.click();
        if (!modulName.isEmpty()){
            WebElement module = Driver.get().findElement(By.xpath("//*[text()='"+modulName+"']"));
            module.click();

        }
    }

}
