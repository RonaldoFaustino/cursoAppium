package org.example.appium.test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalaculadoraTest {

        private AndroidDriver driverMobile;

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
            WebElement el1 = driverMobile.findElement(By.xpath("//android.widget.ImageButton[@content-desc='2']"));
            el1.click();
            WebElement el2 = driverMobile.findElement(AppiumBy.accessibilityId("plus"));
            el2.click();
            WebElement el3 = (WebElement) driverMobile.findElement(AppiumBy.accessibilityId("2"));
            el3.click();
            WebElement el4 = (WebElement) driverMobile.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
            el4.click();

            WebElement resultado = driverMobile.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));

            Assert.assertEquals("O resultado esperdo não é 4","4", resultado.getText());
        }

        @After
        public void tearDown() {
            driverMobile.quit();
        }


}
