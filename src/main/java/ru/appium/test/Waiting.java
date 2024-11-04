package ru.appium.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Waiting {

    private final AppiumDriver<?> driver;

    public Waiting(AppiumDriver<?> driver) {
        this.driver = driver;
    }

    public boolean isVisible(MobileElement element){
        return isVisible(element, 5);
    }

    public boolean isVisible(MobileElement element, long timeOutInSeconds){
        try {
            until(ExpectedConditions.visibilityOf(element), 5);
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }

    public boolean isVisible(By by,long timeOutInSeconds){
        try{
            until(ExpectedConditions.presenceOfElementLocated(by), timeOutInSeconds);
            return true;
        } catch (TimeoutException e){
            return false;
        }
    }


    private void until (ExpectedCondition<?> condition, long timeOutInSeconds){
        try {
            disableImpicitWait();
            new WebDriverWait(driver,timeOutInSeconds).until(condition);
        } finally {
            enableImpicitWait();
        }
    }

    private void enableImpicitWait(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    private void disableImpicitWait(){
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }
}
