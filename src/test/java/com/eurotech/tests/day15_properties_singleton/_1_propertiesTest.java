package com.eurotech.tests.day15_properties_singleton;

import com.eurotech.utilities.ConfigReader;
import org.testng.annotations.Test;

public class _1_propertiesTest {

    @Test
    public void test1() {
        String s1 = ConfigReader.get("url");
        String s2 = ConfigReader.get("browser");
        String s3 = ConfigReader.get("password");
        String s4 = ConfigReader.get("email");
        String s5 = ConfigReader.get("e_mail"); // null

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
        System.out.println("s5 = " + s5);
    }
}
