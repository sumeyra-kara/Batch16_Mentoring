package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilPage extends BasePage {
    @FindBy(xpath = "//ol//li[2]")
    public WebElement userProfilePageName;

    public void navigateUserProfileTabs (String tabName){
        WebElement element = Driver.get().findElement(By.xpath("//li//button[text()='"+tabName+"']"));
        element.click();
    }
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement messageText;

    @FindBy(xpath = "//span[@class='d-none d-md-block dropdown-toggle ps-2']")
    public WebElement userNameProfil;





}
