package org.example.core;

import org.openqa.selenium.By;

public class BasePage {

    public void escrever(By by, String texto){
        DriverFactory.getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return DriverFactory.getDriver().findElement(by).getText();

    }

    public void selecionarCombo(By by, String valor){
        DriverFactory.getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public void clicarPorTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void clicar(By by){
        DriverFactory.getDriver().findElement(by).click();
    }

    public boolean isCheckMarcado(By by){
        return  DriverFactory.getDriver().findElement(by).getAttribute("checked").equals("true");
    }
}
