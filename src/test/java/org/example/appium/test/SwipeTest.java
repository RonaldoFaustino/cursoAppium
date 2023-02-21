package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();


    @Test
    public void deveRealizarSwipe() throws InterruptedException {
        menuPage.acessarSwipe();

        Assert.assertTrue(menuPage.existeUmElementoPorTexto("a esquerda"));
        menuPage.swipeDireita(0.9,0.1);
        Assert.assertTrue(menuPage.existeUmElementoPorTexto("você consegue"));
        menuPage.clicarPorTexto("›");
        Assert.assertTrue(menuPage.existeUmElementoPorTexto("Chegar até o fim!"));
        menuPage.swipeDireita(0.1,0.9);
        Assert.assertTrue(menuPage.existeUmElementoPorTexto("você consegue"));
        menuPage.clicarPorTexto("‹");
    }
}
