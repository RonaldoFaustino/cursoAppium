package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.AccordionPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {

    MenuPage menuPage = new MenuPage();

    AccordionPage accordionPage = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){

        menuPage.acessarAccordion();

        accordionPage.selecionarOpcao1();

        Assert.assertEquals("Esta é a descrição da opção 1",accordionPage.obterValorOpcao1());





    }
}
