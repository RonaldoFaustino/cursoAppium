package org.example.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.util.List;

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

    public boolean existeUmElementoPorTexto(String texto){
         List<MobileElement> elementos = DriverFactory.getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
         return elementos.size() > 0;
    }

    public void tap(int x, int y){
        new TouchAction(DriverFactory.getDriver()).tap(PointOption.point(x, y)).perform();

    }


}
