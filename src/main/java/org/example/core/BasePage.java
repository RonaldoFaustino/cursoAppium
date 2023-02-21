package org.example.core;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static org.example.core.DriverFactory.getDriver;

public class BasePage {

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

    public void clicarDuploPorTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public boolean isCheckMarcado(By by){
        return  getDriver().findElement(by).getAttribute("checked").equals("true");
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
         List<WebElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
         return elementos.size() > 0;
    }

    public void tap(int x, int y){
        new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
    }

    public void  scroll(double inicio, double fim){
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * inicio);
        int end_y = (int) (size.height * fim);

//        new TouchAction(getDriver()).press(x, start_y)
//                .waitAction(Duration.ofMillis(500))
//                .moveTo(x,end_y)
//                .release()
//                .perform();
        TouchAction dragNDrop = new TouchAction(getDriver())
                .press(PointOption.point(x,start_y))
                .waitAction(WaitOptions
                        .waitOptions(Duration
                                .ofMillis(500)))
                .moveTo(PointOption.point(x, end_y))
                .release();

        dragNDrop.perform();
    }

    public String obterTituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta(){
        return obterTexto(By.id("android:id/message"));
    }


}
