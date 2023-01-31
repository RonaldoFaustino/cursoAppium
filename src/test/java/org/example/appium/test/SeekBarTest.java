package org.example.appium.test;

import org.example.page.FormularioPage;
import org.example.page.MenuPage;
import org.junit.Before;
import org.junit.Test;

public class SeekBarTest {

    private MenuPage menuPage = new MenuPage();

    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void init(){
        menuPage.acessarFormulario();
    }

    @Test
    public void deveInteragirComSeekBar(){
        //clicar no seekbar
        formularioPage.clicarSeekBar(0.05);
        formularioPage.salvar();
    }
}
