package org.example.appium.test.core;

import org.example.core.DriverFactory;
import org.junit.After;
import org.junit.AfterClass;

public class BaseTest{

    @AfterClass
    public static void finalizarClasse(){
        //DriverFactory.killDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.killDriver();
        //DriverFactory.getDriver().resetApp();
    }
}
