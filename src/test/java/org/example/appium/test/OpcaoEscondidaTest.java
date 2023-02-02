package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class OpcaoEscondidaTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida(){
        menuPage.scroll(0.9,0.1);

        menuPage.clicarPorTexto("Opção bem escondida");

        Assert.assertEquals("Você achou essa opção",menuPage.obterMensagemAlerta());

        menuPage.clicarPorTexto("OK");
    }
}
