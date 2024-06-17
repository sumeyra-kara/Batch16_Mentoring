package com.eurotech.tests.day14_jsExecuter_FileUpload;
import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class _4_FileUploadTask {
    /*
     * resources klasöründe fileUploadDemo.txt dosyası oluştur.
     * https://the-internet.herokuapp.com/upload sitesine git
     * sitedeki dosya yükleme kısmına bu dosyayı yükle (dynamic path ile)
     * Upload butonuna bas
     * çıkan sayfadan yüklenen dosyanın ismini doğrula
     */
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactor.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDown() {
        WebDriverFactor.wait(2);
        //driver.close();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/upload");
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/fileUploadDemo.txt";
        String fullPath = projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        fileUpload.sendKeys(fullPath);

        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement textName = driver.findElement(By.id("uploaded-files"));
        System.out.println("textName.getText() = " + textName.getText());
        String expected = "fileUploadDemo.txt";
        String actual = textName.getText();
        Assert.assertEquals(expected,actual);


    }
}
