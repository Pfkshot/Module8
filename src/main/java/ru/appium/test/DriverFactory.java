package ru.appium.test;



import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.remote.MobileCapabilityType.*;

public class DriverFactory {
    AppiumDriver<?> driver;

    public AppiumDriver<?> setUp(Platform platform) throws MalformedURLException {
        switch (platform){
            case IOS:
                return createIosDriver();
            case ANDROID:
                createAndroidDriver();
            default: throw new IllegalArgumentException ("No such platform");
        }
    }

    private IOSDriver<?> createIosDriver(){
        return null;
    }

    public AndroidDriver<?> createAndroidDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ANDROID");

        capabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(APP,"/Users/PC/Desktop/Test/AutotestMobile/lesson8/Спортмастер_ интернет-магазин_4.63.2-google_APKPure.apk");
        capabilities.setCapability(NO_RESET, true);// чтобы кеш не чистился поле каждого запуска

        URL remoteURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<>(remoteURL, capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return (AndroidDriver<?>) driver;
    }
}
