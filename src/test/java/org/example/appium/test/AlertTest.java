package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.AlertaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AlertTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    AlertaPage alertaPage = new AlertaPage();

    @Test
    public void deveConfirmarAlerta(){

        //acessar menu alerta
        menuPage.acessarAlertas();

        //clicar em alerta confirm
        alertaPage.clicarAlertaConfirm();

        //verificar os textos
        Assert.assertEquals("Info", alertaPage.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alertaPage.obterMensagemAlerta());

        //confirmar alerta
        alertaPage.confirmarAlerta();

        //veririfcar nova mensagem
        Assert.assertEquals("Confirmado",alertaPage.obterMensagemAlerta());

        //sair
        alertaPage.sair();



    }

}
