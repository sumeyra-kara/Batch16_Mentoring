package com.eurotech.tests.day15_properties_singleton;

import org.testng.annotations.Test;

public class _3_SingletonPatternTest {
    @Test
    public void test() {
        String s = _2_SingletonPattern.getDriver();
        System.out.println("s = " + s);



    }
}
