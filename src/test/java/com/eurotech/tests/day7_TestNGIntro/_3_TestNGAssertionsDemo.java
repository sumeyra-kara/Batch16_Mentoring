package com.eurotech.tests.day7_TestNGIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _3_TestNGAssertionsDemo {

    @Test
    public void test1(){
        Assert.assertEquals("a","a","message");
        Assert.assertTrue(10<11);
        Assert.assertFalse(1>5);
        Assert.assertNotEquals("a","b");
        Assert.assertNotNull(22);
        Assert.assertNull(null);

        Assert.assertTrue("actual".contains("actual"));
    }
}
