package org.example.appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.appium.test.core.BaseTest;
import org.example.core.DriverFactory;
import org.example.page.FormularioPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;
import java.util.List;

public class FormularioTest extends BaseTest {

    private AndroidDriver<MobileElement> driverMobile;

    private MenuPage menuPage = new MenuPage();

    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void setUp() throws MalformedURLException {
        driverMobile = DriverFactory.getDriver();
    }


    @Test
    public void devePreencherCampoTexto() {
        //Selecionar Fomulario
        List<MobileElement> elementosEncontrados = driverMobile.findElements(By.className("android.widget.TextView"));
        for (MobileElement elementos : elementosEncontrados) {
            System.out.println(elementos.getText());
        }
        elementosEncontrados.get(1).click();

        //Escrever nome
        formularioPage.escreverNome("Teste");

        //MobileElement campoNome = driverMobile.findElement(MobileBy.AccessibilityId("nome"));
        //campoNome.sendKeys("Teste");

        //Validar Nome
        Assert.assertEquals("Campo nome está errado: ", "Teste", formularioPage.obterNome());
    }

    @Test
    public void deveInteragirComCombo() {
        //Selecionar Fomulario
        menuPage.acessarFormulario();

        //Clicar no Combo
        formularioPage.selecionarCombo("Nintendo Switch");
        Assert.assertEquals("Foi selecionado o console errado: ", "Nintendo Switch", formularioPage.obterValorCombo());
    }

    @Test
    public void deveInteragirSwitchCheckBox() {
        //Selecionar Fomulario
        menuPage.acessarFormulario();

        //verificar status dos elementos
        Assert.assertFalse(formularioPage.isCheckMarcado());
        Assert.assertTrue(formularioPage.isSwitchMarcado());

        //clicar nos elementos
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        //verificar estados alterados
        Assert.assertTrue(formularioPage.isCheckMarcado());
        Assert.assertFalse(formularioPage.isSwitchMarcado());
    }

    @Test
    public void devePreencherFomularioCompleto() {
        //Selecionar Fomulario
        menuPage.acessarFormulario();

        //Escrever nome
        formularioPage.escreverNome("Teste");

        //Validar Nome
        Assert.assertEquals("Campo nome está errado: ", "Teste", formularioPage.obterNome());

        //Clicar no Combo
        formularioPage.selecionarCombo("Nintendo Switch");

        //verificar a opção selecionada
        Assert.assertEquals("Foi selecionado o console errado: ", "Nintendo Switch", formularioPage.obterValorCombo());

        ///verificar status dos elementos
        Assert.assertFalse(formularioPage.isCheckMarcado());
        Assert.assertTrue(formularioPage.isSwitchMarcado());

        //clicar nos elementos
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        //verificar estados alterados
        Assert.assertTrue(formularioPage.isCheckMarcado());
        Assert.assertFalse(formularioPage.isSwitchMarcado());
    }

}
