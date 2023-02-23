package org.example.page;

import org.example.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.example.core.DriverFactory.getDriver;

public class MenuPage extends BasePage {
    public void acessarFormulario(){
        clicarPorTexto("Formulário");
    }
    public void acessarSplash(){
        clicarPorTexto("Splash");
    }

    public void acessarAlertas(){
        clicarPorTexto("Alertas");
    }

    public void acessarAbas(){
        clicarPorTexto("Abas");
    }

    public void acessarCliques(){
        clicarPorTexto("Cliques");
    }
    public void acessarAccordion(){
        clicarPorTexto("Accordion");
    }

    public void acessarSwipe(){
        clicarPorTexto("Swipe");
    }

    public void clicarSwipeList(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));
        scroll(0.1,0.9);
        clicarPorTexto("Swipe List");
    }

    public void clicarDragNDrop(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@text='Formulário']")));
        scroll(0.9,0.1);
        clicarPorTexto("Drag and drop");
    }


}
