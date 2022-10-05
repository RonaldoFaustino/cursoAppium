package org.example.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.example.appium.core.DriverFactory;
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
            driverMobile = DriverFactory.getDriver();
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

    @Test
    public void devePreencherFomularioCompleto() {
        //Selecionar Fomulario
        MobileElement  findElement = driverMobile.findElement(By.xpath("//*[@text='Formulário']"));
        findElement.click();

        //Escrever nome
        MobileElement campoNome = driverMobile.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Teste");
        //Validar Nome
        String text = campoNome.getText();
        Assert.assertEquals("Campo nome está errado: ","Teste",text);

        //Clicar no Combo
        driverMobile.findElement(MobileBy.AccessibilityId("console")).click();

        //Selecionar a opção desejada
        driverMobile.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

        //verificar a opção selecionada
        String getText = driverMobile.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Foi selecionado o console errado: ","Nintendo Switch", getText);

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
    public void tearDown(){
       DriverFactory.killDriver();
    }


}
