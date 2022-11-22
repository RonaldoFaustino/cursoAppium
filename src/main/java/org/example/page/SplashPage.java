package org.example.page;

import org.example.core.BasePage;
import org.example.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SplashPage extends BasePage {

    public boolean isTelaSplashVisivel(){
     return existeUmElementoPorTexto("Splash!");
    }

    public void aguardarSplashSumir(){
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
    }
}
