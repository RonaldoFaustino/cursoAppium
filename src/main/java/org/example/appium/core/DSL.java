package org.example.appium.core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static org.example.appium.core.DriverFactory.getDriver;


public class DSL {

    public void escrever(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();

    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public void clicarPorTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public boolean isCheckMarcado(By by){
        return  getDriver().findElement(by).getAttribute("checked").equals("true");
    }
}
