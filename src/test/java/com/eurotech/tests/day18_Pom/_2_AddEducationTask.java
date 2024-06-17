package com.eurotech.tests.day18_Pom;

import com.eurotech.pages.*;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2_AddEducationTask extends TestBase {
    /*
         1-open chrome browser
         2-navigate to https://www.krafttechexlab.com/login by using configuration.properties
         3-login with parameterized/non-parameterized method ----
         4-Assert successful login with user name ---
         5-Navigate to My Profile with related method ---
         6-Verify that User Profile page is displayed ---
         7-Navigate to Add Education tab with related method --
         8-Verify that add education page is displayed ---
         9-Fill the form with parameterized method (use actions class)
         10-Verify that added education record can be seen at user profile page... (assert with school name)
         11-Delete last added education record
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage =new DashboardPage();
    ProfilPage profilPage=new ProfilPage();
    AddEducationPage addEducationPage = new AddEducationPage();

    @Test
    public void test() {
        driver.get(ConfigReader.get("url"));
        loginPage.login();
        Assert.assertEquals(profilPage.userNameProfil.getText(),"sevgi");

        dashboardPage.menu("sevgi","My Profile");
        Assert.assertTrue(profilPage.userProfilePageName.isDisplayed());
        profilPage.navigateUserProfileTabs("Add Education");
        BrowserUtils.waitFor(3);
        System.out.println("profilPage.addEducationButtonText.isDisplayed() = " + addEducationPage.addEducationButton.getText());
        System.out.println("addEducationPage.schollBootcamp.isDisplayed() = " + addEducationPage.schollBootcamp.isDisplayed());
        System.out.println("addEducationPage.studyText.isDisplayed() = " + addEducationPage.studyText.isDisplayed());


        addEducationPage.schollBootcamp.sendKeys("Informatik");
        addEducationPage.degreeorCertificate.sendKeys("OCA");
        addEducationPage.study.sendKeys("Darmstadt Universität Informatik");
        addEducationPage.fromDate.sendKeys("12122012");
        addEducationPage.toDate.sendKeys("10102016");
        addEducationPage.programDescription.sendKeys("Java,Selenium,HTML");
        addEducationPage.addEducationButton.click();
        Assert.assertTrue(addEducationPage.schullName.getText().contains("Informatik"));

        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(addEducationPage.deleteButton);
        BrowserUtils.waitFor(2);
        driver.switchTo().alert().accept();

    }
}
