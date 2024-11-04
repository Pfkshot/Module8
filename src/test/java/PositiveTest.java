import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import ru.appium.test.DriverFactory;
import ru.appium.test.MainScreen;
import ru.appium.test.Platform;
import ru.appium.test.screens.CartScreen;
import ru.appium.test.screens.CatalogScreen;

import java.net.MalformedURLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PositiveTest{
    private final DriverFactory driverFactory = new DriverFactory();
    AppiumDriver<?> driver;

    @BeforeAll
    public void SetDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
    }

    @Test
    void makeOrder(){
        MainScreen mainScreen = new MainScreen(driver);
        //Ожидание загрузки Главного экрана
        mainScreen.getSearchWrap().isDisplayed();
        //переход в каталог
        mainScreen.goToCatalog();
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        //переход в Обувь -> Мужчинам -> Кеды
        catalogScreen.chooseShoesBtnCategory().chooseMenCategoryBtn().chooseSneakersCategoryBtn();
        //Добавление первого товара в корзину
        catalogScreen.addFirstItemToCart();
        //Выбор минимального размера
        if (catalogScreen.isChooseSizeVisible());
            catalogScreen.chooseMinSize();
        //нажимаем кнопку "В корзину"
        catalogScreen.clickFinishSelect();
        //проверяем, что появилось уведомление "Товар добавлен в корзину"
        Assertions.assertTrue(catalogScreen.isAddToCartInfoVisible());
        //переходим в корзину
        catalogScreen.cartBtnClick();
        CartScreen cartScreen = new CartScreen(driver);
        //переходим к оформлению
        cartScreen.toBuyBtn();
        //Выбираем "Продолжить без регистрации"
        cartScreen.CWR();
        //Ищем пункт выдачи 1-й в списке Гражданский пр-т 31
        cartScreen.ChooseShop();
        //Выбираем найденный пункт выдачи
        cartScreen.Select();
        //Проверяем, что мы на странице оформления заказа
        cartScreen.getOrderTitle().isDisplayed();
        //нажимаем оформить
        cartScreen.MakeOrderBtn();
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }

}
