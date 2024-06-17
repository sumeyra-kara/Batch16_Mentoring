package com.eurotech.tests.day15_properties_singleton;

import com.eurotech.utilities.ConfigReader;

public class _2_SingletonPattern {
    private _2_SingletonPattern(){}
    private static String driver;
    public static String getDriver(){

        if (driver==null){
            System.out.println("driver null'dur.Kullanmak icin deger atayiniz");
            driver= ConfigReader.get("browser");
        } else {
            System.out.println("driver'in degeri vardir, kullanabilirsiniz.");
        }
        return driver;

    }

}
