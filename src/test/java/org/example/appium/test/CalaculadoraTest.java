package org.example.appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalaculadoraTest {

        private AndroidDriver<MobileElement> driverMobile;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "emulator");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
            desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);


            driverMobile = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        }

        @Test
        public void sampleTest() {
            MobileElement el1 = (MobileElement) driverMobile.findElementByAccessibilityId("2");
            el1.click();
            MobileElement el2 = (MobileElement) driverMobile.findElementByAccessibilityId("plus");
            el2.click();
            MobileElement el3 = (MobileElement) driverMobile.findElementByAccessibilityId("2");
            el3.click();
            MobileElement el4 = (MobileElement) driverMobile.findElementById("com.google.android.calculator:id/result_preview");
            el4.click();
        }

        @After
        public void tearDown() {
            driverMobile.quit();
        }


}
