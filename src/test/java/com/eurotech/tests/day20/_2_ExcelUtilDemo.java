package com.eurotech.tests.day20;

import com.eurotech.utilities.ConfigReader;
import com.eurotech.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class _2_ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        /**
         * Create an object from ExcelUtil class
         * it accepts two arguments
         * argument 1 : location of the excel file (path)
         * argument 2 : sheet that we want to open (sheetName)
         */

        ExcelUtil excelData = new ExcelUtil(ConfigReader.get("excelFile"), "Test");

        //get row count- kac satir bilgi var?
        System.out.println("excelData.rowCount() = " + excelData.rowCount()); // 12

        //get column names
        List<String> columnsNames = excelData.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);

        //get all data
        String[][] dataArray = excelData.getDataArray();
        System.out.println("Arrays.deepToString(dataArray) = " + Arrays.deepToString(dataArray));

        //get all data without first row(ilk satir olmadan tüm satirlar)
        String[][] dataArrayWithoutFirstRow = excelData.getDataArrayWithoutFirstRow();
        System.out.println("Arrays.deepToString(dataArrayWithoutFirstRow) = " + Arrays.deepToString(dataArrayWithoutFirstRow));

        //get all data in a list of map
        List<Map<String, String>> dataList = excelData.getDataList();
        System.out.println("dataList.get(2).get(\"City\") = " + dataList.get(2).get("City"));
        System.out.println("-----------------------------");
        Map<String, String> sekizinciSatir = dataList.get(8);
        System.out.println("sekizinciSatir = " + sekizinciSatir);
        System.out.println("sekizinciSatir.get(\"Age\") = " + sekizinciSatir.get("Age"));

        System.out.println("excelData.getCellData(2,3) = " + excelData.getCellData(2, 3));
    }
}
