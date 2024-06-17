package com.eurotech.tests.day20;

import com.eurotech.pages.DashboardPage;
import com.eurotech.pages.LoginPage;
import com.eurotech.tests.TestBase;
import com.eurotech.utilities.ConfigReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _4_DDF_LoginTest  extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @DataProvider // 2d array kullanarak istenilen verileri teste gonderir
    public Object[][] userData(){
        ExcelUtil qaTeam1 = new ExcelUtil(ConfigReader.get("excelFile"), "QaTeam1");
        String[][] qaTeam1DataArrayWithoutFirstRow = qaTeam1.getDataArrayWithoutFirstRow();
        return qaTeam1DataArrayWithoutFirstRow;
    }

    @Test(dataProvider = "userData")
    public void loginTestWithDataProvider(String yourName, String email, String password){
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        extentLogger = report.createTest("TC-005 "+yourName+"'s Login Test");

        extentLogger.info("Navigate to "+ConfigReader.get("url"));
        driver.get(ConfigReader.get("url"));

        extentLogger.info("Login with valid credentials");
        loginPage.login(email,password);

        extentLogger.info("Verify success login with username");
        String actualUserName = dashboardPage.userName.getText();
        Assert.assertEquals(actualUserName,yourName);

        extentLogger.pass("Passed..!");


    }
}
