package com.eurotech.tests.day18_Pom;

import com.eurotech.pages.*;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _1_TaskEditProfile extends TestBase {
    /*
     * THIS TASK WILL BE IMPLEMENTED USING POM
     * which means we will have one test class for the test
     * and one corresponding page having all locators and actions for the page
     *
     * go to https://www.krafttechexlab.com/login
     * enter valid credentials (your credentials)
     * wait for usernames are displayed (both middle and right top)
     * go to sevgi --> myProfile
     * wait for page title is displayed
     *** create a method that navigate you to specific module based on the given parameter
     * go to Edit Profile page using the method just mentioned above
     * fill out the fields
     * -->about --> SDET programme , graduated from KraftTech
     * -->Company --> Google
     * -->Job  --> QA Automation Engineer
     * -->Website --> www.google.com
     * -->Location --> Antalya
     * -->Skills --> Java,Selenium, TestNG
     * click save changes button
     * verify that "Profile Updated" message is appeared
     */
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ProfilPage profilPage = new ProfilPage();
    EditProfilePage editProfilePage = new EditProfilePage();
    BasePage ba  =new DashboardPage();
    @Test
    public void editProfileTest() {
        driver.get(ConfigReader.get("url"));
        loginPage.login();
        BrowserUtils.waitForClickablility(profilPage.userNameProfil,5);
        String actualusername = dashboardPage.myProfile.getText();
        String expectedusername = ConfigReader.get("userName");
        Assert.assertNotEquals(actualusername,expectedusername);


        //dashboardPage.menu("Forms","Time"); // menüyü dinamik yaptik
        dashboardPage.menu(ConfigReader.get("userName"),"My Profile");

        System.out.println("profilPage.userProfilePageName.isDisplayed() = " + profilPage.userProfilePageName.isDisplayed());

        profilPage.navigateUserProfileTabs("Edit Profile");
        editProfilePage.about.clear();
        editProfilePage.about.sendKeys("SDET programme , graduated from KraftTech");

        editProfilePage.company.clear();
        editProfilePage.company.sendKeys("Google");
        // BrowserUtils.clearAndSendKeys(editProfilePage.company,"Google"); --- kisa yolu

        editProfilePage.selectJob("SDET");

        //editProfilePage.website.sendKeys("www.google.com");
        BrowserUtils.clearAndSendKeys(editProfilePage.website,"www.google.com");
        BrowserUtils.clearAndSendKeys(editProfilePage.locationBox,"Antalya");
        BrowserUtils.clearAndSendKeys(editProfilePage.skillsBox,"Java,Selenium,SQL");

        //editProfilePage.saveChangesButton.click();
        BrowserUtils.clickWithJS(editProfilePage.saveChangesButton);

        String actualText = profilPage.messageText.getText();
        String expectedText="Profile Updated";
        Assert.assertTrue(profilPage.messageText.isDisplayed());
        Assert.assertEquals(actualText,expectedText);


    }
}
