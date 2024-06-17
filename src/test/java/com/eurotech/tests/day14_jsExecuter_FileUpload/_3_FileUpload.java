package com.eurotech.tests.day14_jsExecuter_FileUpload;

import com.eurotech.utilities.WebDriverFactor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.time.Duration;
import java.util.Properties;

public class _3_FileUpload {
    /*

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
    public void systemPropertiesTest() {
        //Sistemin bütün özelikkleri
        Properties properties = System.getProperties();
        properties.list(System.out);
        System.out.println("System.getProperty(os.name) = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
    }

    @Test
    public void fileUpload() {
        /*
         * proje kapsamında dosya yükleme işlemi
         * test klasörü altında resources directory'si oluşturulur (projeye dışarıdan eklenecek dosyalar burada olur.)
         * upload edilecek dosya bu klasöre kopyalanır (ccc.txt)
         * System.getProperty() metodu kullanılarak.. projenin yolu (path) alınır..
         * upload edilecek dosyaya sağ click yapılarak, projeden sonraki yolu (path) alınır..
         * iki path araya "/"  slash konularak birleştirilir. Artık projeyi her indirenin kullanabileceği path oluşur..
         * bu path kullanılarak dosya upload edilir.
         * go to https://demoqa.com/upload-download
         * upload ccc.txt
         * verify that the file is uploaded
         */
        String projectPath = System.getProperty("user.dir");
        String filePath ="src/test/resources/ccc.txt";
        String fullPath = projectPath+"/"+filePath;
        System.out.println("fullPath = " + fullPath);

        driver.get("https://demoqa.com/upload-download");
        WebElement choose = driver.findElement(By.id("uploadFile"));
        choose.sendKeys(fullPath);

        WebElement uploadedFilePath = driver.findElement(By.id("uploadedFilePath"));
        String actualFileName  =uploadedFilePath.getText();
        String expectedFileName = "ccc.txt";
        Assert.assertNotEquals(actualFileName,expectedFileName);


    }
}
