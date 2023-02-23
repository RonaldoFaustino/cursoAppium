package org.example.appium.test;

import org.example.appium.test.core.BaseTest;
import org.example.page.MenuPage;
import org.example.page.SwipeListPage;
import org.junit.Test;

public class SwipeElementTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    public void deveResolverNossoDesafio(){

        menuPage.clicarSwipeList();
        swipeListPage.swipeelementoRigth("Opção 3");

        //TODO
        // finalizar teste swipe list
    }
}
