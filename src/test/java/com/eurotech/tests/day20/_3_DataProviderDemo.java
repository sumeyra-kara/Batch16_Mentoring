package com.eurotech.tests.day20;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3_DataProviderDemo {

    @DataProvider // 2d array kullanarak istenilen verileri teste gonderir
    public Object[][] testData1(){
        String [][] notes={
                {"Hasan Sarı","70","100"},
                {"Veysel Candan","80","98"},
                {"Hanife Kara","90","95"},
                {"Burhan Eratlı","87","98"},
                {"Şule Aylin Atmaca","100","93"},
                {"Eylem Sönmez","89","97"}
        };
        return notes;
    }

    @Test(dataProvider = "testData1")
    public void test1(String fullName, String visaNote, String finalNote){
        System.out.println(fullName+"-> "+visaNote+"-> "+finalNote);
    }

    @DataProvider (name = "Student Notes")
    public Object[][] testData2(){
        Object [][] notes={
                {"Hasan Sarı",70,100},
                {"Veysel Candan",80,98},
                {"Hanife Kara",90,95},
                {"Burhan Eratlı",87,98},
                {"Şule Aylin Atmaca",100,93},
                {"Eylem Sönmez",89,97}
        };
        return notes;
    }

    @Test (dataProvider = "Student Notes")
    public void test2(String fullName, int visaNote, int finalNote){
        System.out.println(fullName+"-> "+visaNote+"-> "+finalNote+ " Yıl Sonu Notu: "+(visaNote*0.4+finalNote*0.6));
    }
}
