package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.DragDropPage;
import org.example.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class DragNDropTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private DragDropPage dragDropPage = new DragDropPage();

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};

    @Test
    public void deveEfetuarDragNDrop() throws InterruptedException {

        menuPage.clicarDragNDrop();
        menuPage.aguardar(3000);
        Assert.assertEquals("A lista esperada está incorreta", estadoInicial,dragDropPage.obterLista());
        dragDropPage.obterLista();
        dragDropPage.arrastar("Esta","Drag em Drop!");

    }
}
