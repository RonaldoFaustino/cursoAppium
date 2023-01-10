package org.example.appium.test;

import org.example.page.AlertaPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class ClickEmCoordenadas {
    MenuPage menuPage = new MenuPage();
    AlertaPage alertaPage = new AlertaPage();

    @Test
    public void deveClicarForaDoAlerta(){
        menuPage.acessarAlertas();
        alertaPage.clicarAlertaSimples();
        alertaPage.clicarForaCaixa();
        alertaPage.clicarForaCaixa();
        Assert.assertFalse(alertaPage.existeUmElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}
