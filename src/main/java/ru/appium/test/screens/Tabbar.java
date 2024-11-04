package ru.appium.test.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Tabbar extends Screen {

    @AndroidFindBy(id = "catalog_graph")
    MobileElement catalogBtn;

    @AndroidFindBy(id = "dashboard_graph")
    MobileElement dashboard_graph;

    @AndroidFindBy(id = "ordering_graph")
    MobileElement cartBtn;


    public Tabbar(AppiumDriver<?> driver) {
        super(driver);
    }

    public void goToCatalog(){
        catalogBtn.click();
    }

    public void goToCart(){
        cartBtn.click();
    }

}
