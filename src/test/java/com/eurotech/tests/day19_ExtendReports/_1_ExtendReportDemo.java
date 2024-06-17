package com.eurotech.tests.day19_ExtendReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.eurotech.utilities.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _1_ExtendReportDemo {
    ExtentReports report;  // Bu obje raporu olusturmak ve rapor ile ilgili metadata'yi tabimlamak icin kullanilir
    ExtentHtmlReporter htmlReporter; // Bu obje raporumuzun html formatinda olmasini saglar

    ExtentTest extentLogger; // her test ile ilgili log kayitlarini ve test adimlarini tanimlamamizi saglar

    @BeforeMethod
    public void setUp() {
        // initialize the object
        report=new ExtentReports();

        //raporun kayit edilecegi yeri belirleyelim
        String projectPath = System.getProperty("user.dir"); // proje Yolu
        String reportPath = projectPath+ "/test-output/report.html";

        // html raporumuzu olusturalim
        htmlReporter=new ExtentHtmlReporter(reportPath);

        // html raporumuzu report (metadata) nesnesi ile iliskilendirelim
        report.attachReporter(htmlReporter);

        // raporun basligini duzenleyelim
        htmlReporter.config().setReportName("Smoke Test");

        //raporun meta datasini duzenleyelim
        report.setSystemInfo("Enviroment","Test");
        report.setSystemInfo("Browser", ConfigReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("tester",System.getProperty("user.name"));
        report.setSystemInfo("PO",System.getProperty("Figen"));

    }

    @Test
    public void test1() {
        // mevcuz testimizin adini girelim
        extentLogger= report.createTest("Test-001 First Test");

        //test stepleri girelim
        extentLogger.info("Chrome browser'i ac");
        // kod buraya yazilacak
        extentLogger.info("Web sitesine git");
        extentLogger.info("Email gir");
        extentLogger.info("Password gir");
        extentLogger.info("Login butonuna click yap");
        extentLogger.info(ConfigReader.get("userName")+" ile dogrulama yap");

        extentLogger.pass("Gecti");
    }

    @AfterMethod
    public void tearDown() {
        report.flush();
    }
}
