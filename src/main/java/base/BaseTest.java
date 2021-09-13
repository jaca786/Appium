package base;

import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import screens.nativeapp.BookingFlights;
import screens.nativeapp.FlightSearch;
import screens.nativeapp.HomePage;
import utils.AppiumServer;
import utils.CommonUtils;
import java.io.IOException;

public class BaseTest {

    public static AndroidDriver driver;
    public static BookingFlights mmt ;
    public static HomePage homePage;
    public static FlightSearch flightSearch;

    @BeforeSuite
    public void setup() throws IOException {
        AppiumServer.stop();
        AppiumServer.start();

        if(driver==null) {
            CommonUtils.loadConfigProp("mmt.properties");
            CommonUtils.setCapabilities();
            driver = CommonUtils.getDriver();
            mmt = new BookingFlights(driver);
            homePage = new HomePage(driver);
            flightSearch = new FlightSearch(driver);
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        AppiumServer.stop();
    }

}
