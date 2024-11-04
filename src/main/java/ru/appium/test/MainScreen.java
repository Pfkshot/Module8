package ru.appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.appium.test.screens.Tabbar;

public class MainScreen extends Tabbar {
    @AndroidFindBy(id = "linearLayoutSearchWrap")
    MobileElement searchWrap;

    public MainScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public MobileElement getSearchWrap(){
       return searchWrap;
    }

}
