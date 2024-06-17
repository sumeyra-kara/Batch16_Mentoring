package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EditProfilePage extends BasePage {

    @FindBy(id = "about")
    public WebElement about;

    @FindBy(xpath = "(//input[@name='company'])[1]")
    public WebElement company;

    @FindBy(xpath = "//input[@type='range']")
    public WebElement terms;

    @FindBy(xpath = "//select[@id='job']")
    public WebElement job;

    public void selectJob(String jobName){
        Select select=new Select(job);
        select.selectByVisibleText(jobName);
    }

    @FindBy(xpath = "//input[@name='website']")
    public WebElement website;

    @FindBy(xpath = "(//input[@name='location'])[1]")
    public WebElement locationBox;

    @FindBy(xpath = "//input[@name='skills']")
    public WebElement skillsBox;


    @FindBy(xpath = "//button[text()='Save Changes']")
    public WebElement saveChangesButton;













}
