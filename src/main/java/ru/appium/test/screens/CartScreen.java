package ru.appium.test.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartScreen extends Tabbar {

    @AndroidFindBy(xpath = "//*[contains(@text, \"К оформлению\")]")
    MobileElement toBuyBtn;

    @AndroidFindBy(id = "buttonContinue")
    MobileElement continueWithoutRegistration;

    @AndroidFindBy (id = "buttonAction")
    MobileElement chooseShopBtn;

    @AndroidFindBy(uiAutomator = "text(\"Гражданский пр-т, 31\")")
    MobileElement shopGrazhdanskii31;

    @AndroidFindBy (id = "buttonSelect")
    MobileElement selectBtn;

    @AndroidFindBy(uiAutomator = "text(\"Оформление заказа\")")
    MobileElement orderingTitle;

    @AndroidFindBy(id ="buttonMakeOrder")
    MobileElement setUpTheBuy;

    public CartScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public CartScreen toBuyBtn(){
        toBuyBtn.click();
        return this;
    }

    public CartScreen CWR(){
        continueWithoutRegistration.click();
        return this;
    }

    public CartScreen ChooseShop(){
        chooseShopBtn.click();
        shopGrazhdanskii31.click();
        return this;
    }
    public MobileElement getOrderTitle(){
        return orderingTitle;
    }

    public void Select(){
        selectBtn.click();
    }

    public  void MakeOrderBtn(){
        setUpTheBuy.click();
    }





}
