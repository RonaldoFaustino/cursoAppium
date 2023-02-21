package org.example.page;

import io.appium.java_client.AppiumBy;
import org.example.core.BasePage;
import org.example.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FormularioPage extends BasePage {
    
    public void escreverNome(String nome){
        escrever(AppiumBy.accessibilityId("nome"),nome);
    }

    public String obterNome(){
        return obterTexto(AppiumBy.accessibilityId("nome"));
    }

    public void selecionarCombo(String valor){
        selecionarCombo(AppiumBy.accessibilityId("console"),valor);
    }

    public String obterValorCombo(){
        return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck(){
        clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch(){
        clicar(AppiumBy.accessibilityId("switch"));
    }

    public boolean isCheckMarcado(){
        return isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchMarcado(){
        return isCheckMarcado(AppiumBy.accessibilityId("switch"));
    }

    public void salvar(){
        clicar(By.xpath("//android.widget.Button[@content-desc=\"save\"]/android.widget.TextView"));
    }

    public void salvarDemorado(){
        clicarPorTexto("SALVAR DEMORADO");
    }

    public void clicarSeekBar(double posicao){
       int delta = 55;

       WebElement seek = DriverFactory.getDriver().findElement(AppiumBy.accessibilityId("slid"));
       int y = seek.getLocation().y + (seek.getSize().height / 2);
       System.out.println(y);

       int xInicial = seek.getLocation().x +delta;
       int x = (int) (xInicial + ((seek.getSize().width - 2 * delta) * posicao));
        System.out.println(x);

        tap(y, x);
    }

}
