package org.example.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
            driverMobile.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @Test
        public void devePreencherCampoTexto() {
            //Selecionar Fomulario
            List<MobileElement> elementosEncontrados = driverMobile.findElements(By.className("android.widget.TextView"));
            for(MobileElement elementos: elementosEncontrados){
                System.out.println(elementos.getText());
            }
            elementosEncontrados.get(1).click();

            //Escrever nome
            MobileElement campoNome = driverMobile.findElement(MobileBy.AccessibilityId("nome"));
            campoNome.sendKeys("Teste");
            //Validar Nome
            String text = campoNome.getText();
            Assert.assertEquals("Campo nome está errado: ","Teste",text);
        }

    @Test
    public void deveInteragirComCombo() {
        //Selecionar Fomulario
        MobileElement  findElement = driverMobile.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
        findElement.click();

        //Clicar no Combo
        driverMobile.findElement(MobileBy.AccessibilityId("console")).click();

        //Selecionar a opção desejada
        driverMobile.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //verificar a opção selecionada
        String getText = driverMobile.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Foi selecionado o console errado: ","Nintendo Switch", getText);
    }

    @Test
    public void deveInteragirSwitchCheckBox() {
        //Selecionar Fomulario
        MobileElement  findElement = driverMobile.findElement(By.xpath("//*[@text='Formulário']"));
        findElement.click();

        //verificar status dos elementos
        MobileElement check = driverMobile.findElement(By.className("android.widget.CheckBox"));
        MobileElement switcht = driverMobile.findElement(MobileBy.AccessibilityId("switch"));
        Assert.assertTrue(check.getAttribute("checked").equals("false"));
        Assert.assertTrue(switcht.getAttribute("checked").equals("true"));

        //clicar nos elementos
        check.click();
        switcht.click();

        //verificar estados alterados
        Assert.assertFalse(check.getAttribute("checked").equals("false"));
        Assert.assertFalse(switcht.getAttribute("checked").equals("true"));


    }

        @After
        public void tearDown() {
            driverMobile.quit();
        }


}
