package org.example.appium.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.example.appium.test.core.BaseTest;
import org.example.core.DriverFactory;
import org.example.page.FormularioPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

public class DatePicker extends BaseTest {

    private AndroidDriver<MobileElement> driverMobile;

    private MenuPage menuPage = new MenuPage();

    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void setUp() throws MalformedURLException {
        driverMobile = DriverFactory.getDriver();
        menuPage.acessarFormulario();
    }

    @Test
    public void deveAlterarData(){

        menuPage.clicarPorTexto("01/01/2000");
        menuPage.clicarPorTexto("20");
        menuPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeUmElementoPorTexto("20/02/2000"));
    }

    @Test
    public void deveAlterarHorario(){
        menuPage.clicarPorTexto("06:00");
        menuPage.clicar(MobileBy.AccessibilityId("10"));
        menuPage.clicar(MobileBy.AccessibilityId("55"));
        menuPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeUmElementoPorTexto("10:55"));
    }

}
