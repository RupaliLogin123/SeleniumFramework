package com.thetestingacademy.BaseTest;

import com.thetestingacademy.Driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {
    @BeforeMethod
    public void setup(){
        DriverManager.init();
//        DriverManagerSelenoid.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
//        DriverManagerSelenoid.down();
    }
}
