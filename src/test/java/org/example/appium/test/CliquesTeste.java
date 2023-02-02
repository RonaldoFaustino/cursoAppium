package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.CliquesPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTeste extends BaseTest {
    private MenuPage menuPage = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();

    @Before
    public void setup(){
        menuPage.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){
        cliquesPage.clicqueLongo();
        Assert.assertEquals("Clique Longo", cliquesPage.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        cliquesPage.clicarDuploPorTexto("Clique duplo");
        Assert.assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());
    }
}
