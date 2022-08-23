package org.example.appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class FormularioTest {

        private AndroidDriver<MobileElement> driverMobile;

        @Before
        public void setUp() throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:deviceName", "emulator");
            desiredCapabilities.setCapability("appium:automationName", "uiautomator2");
            desiredCapabilities.setCapability("locationServicesAuthorized", true);
            //desiredCapabilities.setCapability("appium:appPackage", "com.google.android.calculator");
            //desiredCapabilities.setCapability("appium:appActivity", "com.android.calculator2.Calculator");
            //desiredCapabilities.setCapability("noReset",true);
            desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\cursoAppium\\src\\test\\resources\\apks\\CTAppium_1_2.apk");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

            desiredCapabilities.setCapability("appWaitPackage", "com.google.android.permissioncontroller");
            desiredCapabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.ReviewPermissionsActivity");

            driverMobile = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            driverMobile.findElement(By.xpath("//android.widget.Button[@text='Continue']")).click();
            try {
                Thread.sleep(3000);
                driverMobile.findElement(By.xpath("//*[@text='OK']")).click();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Test
        public void sampleTest() {
            System.out.println("Iniciando Teste");
        }

        @After
        public void tearDown() {
            driverMobile.quit();
        }


}
