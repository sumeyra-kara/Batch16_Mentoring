package com.eurotech.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddEducationPage extends BasePage{

    @FindBy(xpath = "//input[@id='school']")
    public WebElement schollBootcamp;
    @FindBy(xpath = "//input[@id='degree']")
    public WebElement degreeorCertificate;

    @FindBy(xpath = "//input[@id='study']")
    public WebElement study;

    @FindBy(xpath = "//label[text()='Study ']")
    public WebElement studyText;


    @FindBy(xpath = "(//input[@id='fromdate'])[2]")
    public WebElement fromDate;
    @FindBy(xpath = "//input[@id='todateedu']")
    public WebElement toDate;
    @FindBy(xpath = "(//textarea[@id='description'])[2]")
    public WebElement programDescription;
    @FindBy(xpath = "(//button[text()='Add Education'])[2]")
    public WebElement addEducationButton;
    @FindBy(xpath = "//span[text()='Informatik']")
    public WebElement schullName;
    @FindBy(xpath = "(//i[@class='bi bi-trash text-danger f-16'])[3]")
    public WebElement deleteButton;

}
