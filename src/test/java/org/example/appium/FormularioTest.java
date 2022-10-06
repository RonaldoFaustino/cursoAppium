package org.example.appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.example.appium.core.DSL;
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

        private DSL dsl = new DSL();

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
            dsl.escrever(MobileBy.AccessibilityId("nome"),"Teste");
            //MobileElement campoNome = driverMobile.findElement(MobileBy.AccessibilityId("nome"));
            //campoNome.sendKeys("Teste");

            //Validar Nome
            Assert.assertEquals("Campo nome está errado: ","Teste",dsl.obterTexto(MobileBy.AccessibilityId("nome")));
        }

    @Test
    public void deveInteragirComCombo() {
        //Selecionar Fomulario
        MobileElement  findElement = driverMobile.findElement(By.xpath("//android.widget.TextView[@text='Formulário']"));
        findElement.click();

        //Clicar no Combo
        //Selecionar a opção desejada
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"),"Nintendo Switch");

        //verificar a opção selecionada
        String getText = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        Assert.assertEquals("Foi selecionado o console errado: ","Nintendo Switch", getText);
    }

    @Test
    public void deveInteragirSwitchCheckBox() {
        //Selecionar Fomulario
        MobileElement  findElement = driverMobile.findElement(By.xpath("//*[@text='Formulário']"));
        findElement.click();

        //verificar status dos elementos
        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

        //clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        //verificar estados alterados
        Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));
    }

    @Test
    public void devePreencherFomularioCompleto() {
        //Selecionar Fomulario
        MobileElement  findElement = driverMobile.findElement(By.xpath("//*[@text='Formulário']"));
        findElement.click();

        //Escrever nome
        dsl.escrever(MobileBy.AccessibilityId("nome"),"Teste");

        //Validar Nome
        Assert.assertEquals("Campo nome está errado: ","Teste",dsl.obterTexto(MobileBy.AccessibilityId("nome")));

        //Clicar no Combo
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"),"Nintendo Switch");

        //verificar a opção selecionada
        Assert.assertEquals("Foi selecionado o console errado: ","Nintendo Switch", dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView")));

        ///verificar status dos elementos
        Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

        //clicar nos elementos
        dsl.clicar(By.className("android.widget.CheckBox"));
        dsl.clicar(MobileBy.AccessibilityId("switch"));

        //verificar estados alterados
        Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
        Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));


    }

    @After
    public void tearDown(){
       DriverFactory.killDriver();
    }


}
