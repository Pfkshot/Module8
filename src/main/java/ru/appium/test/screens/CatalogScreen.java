package ru.appium.test.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

import java.util.List;

public class CatalogScreen extends Tabbar {

    @AndroidFindBy(id = "Обувь")
    MobileElement shoesBtnCategory;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Мужчинам\" ]")
    MobileElement menCategoryBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"кеды\" ]")
    MobileElement sneakersCategoryBtn;

    @AndroidFindBy(id ="buttonCartOld")
    List <MobileElement> addToCartBtns;

    @AndroidFindBy(id ="recyclerViewSizes")
    MobileElement chooseSizeTable;

    @AndroidFindBy(id ="cardView")
    List <MobileElement> size;

    @AndroidFindBy(id = "buttonFinishSelect")
    MobileElement finishSelect;

    @AndroidFindBy(id = "ordering_graph")
    MobileElement cartBtn;

//    @AndroidFindBy(uiAutomator = "new UiScrollable(scrollable(true)).flingToEnd(int maxSwipes)")
//    MobileElement scroll;


//    @AndroidFindBy(id = "buttonContinue")
//    MobileElement continueWithoutRegistration;

//    @AndroidFindBy(uiAutomator = "text(\"Продолжить без регистрации\")")
//    MobileElement continue_without_registration;


    public CatalogScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public CatalogScreen chooseShoesBtnCategory(){
        shoesBtnCategory.click();
        return this;
    }

    public CatalogScreen chooseMenCategoryBtn(){
        menCategoryBtn.click();
        return this;
    }

    public CatalogScreen chooseSneakersCategoryBtn(){
        sneakersCategoryBtn.click();
        return this;
    }

    public CatalogScreen addFirstItemToCart(){
        addToCartBtns.get(0).click();
        return this;
    }

    public boolean isChooseSizeVisible(){
        return chooseSizeTable.isDisplayed();

    }

    public CatalogScreen chooseMinSize(){
        size.get(0).click();
        return this;
    }

    public CatalogScreen clickFinishSelect(){
        finishSelect.click();
        return this;
    }

    public boolean isAddToCartInfoVisible(){
        return waiting.isVisible(new By.ByXPath("//*[contains(@text, \"Товар добавлен в корзину\")]"),5);
    }

    public CatalogScreen cartBtnClick(){
        cartBtn.click();
        return this;
    }

//    public boolean isScroll(){
//        return scroll.isDisplayed();
//    }


//    public CatalogScreen purchaseBtn(){
//        purchase.click();
//        return this;
//    }
//
//    public CatalogScreen CWR(){
//        continueWithoutRegistration.click();
//        return this;
//    }


}
