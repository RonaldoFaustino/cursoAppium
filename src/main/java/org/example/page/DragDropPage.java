package org.example.page;

import io.appium.java_client.AppiumBy;
import org.example.core.BasePage;
import org.example.core.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DragDropPage extends BasePage {

    public void arrastar(String origem, String destino){
        WebElement inicio = DriverFactory.getDriver().findElement(AppiumBy.xpath("//*[@text='"+origem+"']"));
        WebElement fim = DriverFactory.getDriver().findElement(AppiumBy.xpath("//*[@text='"+destino+"']"));

        Actions action = new Actions(DriverFactory.getDriver());
        action.clickAndHold(inicio);
        action.moveToElement(fim);
        action.release();
        action.perform();
    }

    public String[] obterLista(){
        List<WebElement> elements = DriverFactory.getDriver().findElements(AppiumBy.className("android.widget.TextView"));
        String[] retorno = new String[elements.size()];

        for (int i = 0; i < elements.size(); i++){
            retorno[i] = elements.get(i).getText();
            System.out.print("\"" + retorno[i] + "\", ");
        }

        return retorno;
    }
}
