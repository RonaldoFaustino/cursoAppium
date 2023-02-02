package org.example.page;

import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.example.core.BasePage;
import org.openqa.selenium.By;

import static org.example.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void clicqueLongo(){
        new AndroidTouchAction(getDriver()).longPress(ElementOption.element(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))).perform();
    }

    public String obterTextoCampo(){
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}
