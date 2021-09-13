package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonUtils {
    private static Properties properties = new Properties();
    private static DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    private static URL serverUrl;
    private static AndroidDriver driver;
    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String APPLICATION_NAME;
    public static String BASE_PKG;
    public static String APP_ACTIVITY;
    public static String APPIUM_PORT;
    public static String BROWSER_NAME;
    public static String PLATFORM_NAME;
    public static String PLATFORM_VERSION;
    public static String DEVICE_NAME;

    public static void loadConfigProp(String propertyFileName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/properties/"+propertyFileName);
        properties.load(fis);
        EXPLICIT_WAIT_TIME = Integer.parseInt(properties.getProperty("explicit.wait"));
        IMPLICIT_WAIT_TIME = Integer.parseInt(properties.getProperty("implicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(properties.getProperty("default.wait"));
        //APPLICATION_NAME = properties.getProperty("application.path");
        BASE_PKG = properties.getProperty("base.pkg");
        APP_ACTIVITY = properties.getProperty("application.activity");
        APPIUM_PORT = properties.getProperty("appium.server.port");
        BROWSER_NAME = properties.getProperty("browser.name");
        PLATFORM_NAME = properties.getProperty("platform.name");
        PLATFORM_VERSION = properties.getProperty("platform.version");
        DEVICE_NAME = properties.getProperty("device.name");
    }

    public static void setCapabilities() {
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,CommonUtils.PLATFORM_VERSION);
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,CommonUtils.PLATFORM_NAME);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,CommonUtils.DEVICE_NAME);
        desiredCapabilities.setCapability("appActivity",CommonUtils.APP_ACTIVITY);
        desiredCapabilities.setCapability("appPackage",CommonUtils.BASE_PKG);
    }

    public static AndroidDriver getDriver() throws MalformedURLException {
        serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
        driver = new AndroidDriver(serverUrl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
