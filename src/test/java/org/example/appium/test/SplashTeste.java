package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private SplashPage splashPage = new SplashPage();

    @Test
    public void deveAguardarSplashSumir() throws InterruptedException {
        //acessar menu splash
        menu.acessarSplash();

        //verificar que o splash está sendo exibido
        splashPage.isTelaSplashVisivel();

        //aguardar saida do splash
        splashPage.aguardarSplashSumir();

        //verificar que o formulario está aparecendo

        Assert.assertTrue(menu.existeUmElementoPorTexto("Formulário"));

    }
}
