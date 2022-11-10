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

    public String obterNomeCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String obterConsoleCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String obterCheckCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public String obterSwitchCadastrado(){
        return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }


}
