package rough;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class InstallApp {

    public static void main(String args[]) throws InterruptedException, MalformedURLException {
        File app = new File(System.getProperty("user.dir")+"/src/main/resources/app/makemytrip-8-3-8.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,app.getAbsolutePath());

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        driver.quit();
    }
}
