package com.eurotech.tests.day7_TestNGIntro;

import org.testng.annotations.*;

import javax.swing.plaf.PanelUI;

public class _2_Before_AfterMethods {
    /*
    BeforeMethod ve AfterMethod her Test basinda ve sonunda calisir
    BeforeClass ve AfterClass her class basinda ve sonunda calisir
    @Ignore ise gormezden gelir
     */

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void tearDownClass(){
        System.out.println("Before Class");
    }

    @Test (priority = -1)
    public void test1(){
        System.out.println("test1");
    }

    @Test (priority = 2)
    public void test2(){
        System.out.println("test2");
    }

    @Test (priority = 4)
    public void test3(){
        System.out.println("test3");
    }

    @Test
    public void test4(){
        System.out.println("test4");
    }
}
