package org.example.page;

import io.appium.java_client.AppiumBy;
import org.example.core.BasePage;

import static org.example.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeelementoLeft(String opcao){
        swipeElementos(getDriver().findElement(AppiumBy.xpath("//*[@text='"+opcao+"']/..")),0.1,0.9);
    }

    public void swipeelementoRigth(String opcao){
        swipeElementos(getDriver().findElement(AppiumBy.xpath("//*[@text='"+opcao+"']/..")),0.9,0.1);
    }
}
