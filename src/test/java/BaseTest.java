import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.PageFactory;
import ru.appium.test.DriverFactory;
import ru.appium.test.Platform;

import java.net.MalformedURLException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    private final DriverFactory driverFactory = new DriverFactory();
    AppiumDriver<?> driver;

    @BeforeAll
    public void SetDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
    }

    @AfterAll
    public void tearDown(){
        driver.quit();
    }


}
