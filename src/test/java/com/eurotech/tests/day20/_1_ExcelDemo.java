package com.eurotech.tests.day20;

import com.eurotech.utilities.ConfigReader;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _1_ExcelDemo {
    String readFromExcelCell(String path, String sheetName, int row, int column) throws IOException, IOException {
        FileInputStream fis = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet(sheetName);
        String cellValue = sheet.getRow(row).getCell(column).getStringCellValue();
        return cellValue;
    }

    @Test
    public void test1() throws IOException {
        String cell = readFromExcelCell("src/test/resources/LoginList.xlsx","Test",3, 2);
        String cell2 = readFromExcelCell(ConfigReader.get("excelFile"),"Test",5, 0);
        System.out.println("cell = " + cell); // Antalya
        System.out.println("cell2 = " + cell2); // Belgin
    }
}
