package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.AbasPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbas(){
        menuPage.acessarAbas();
        //System.out.println(abasPage.obterMensagemAba1());

        Assert.assertTrue(abasPage.isAba1());

        abasPage.selecionarAba2();

        Assert.assertTrue(abasPage.isAba2());

    }
}
