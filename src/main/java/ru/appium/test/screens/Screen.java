package ru.appium.test.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import ru.appium.test.Waiting;

public class Screen {

    AppiumDriver<?> driver;
    Waiting waiting;

    Screen(AppiumDriver<?> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
        this.driver = driver;
        waiting = new Waiting(driver);
    }

}
