package screens.nativeapp;

import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends ScreenBase {

    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.makemytrip:id/viewAll")
    private WebElement offerViewLink;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.ImageView")
    private WebElement flight;

    public void validateOfferLink() throws InterruptedException {
        Assert.assertTrue(offerViewLink.isDisplayed(), "View ALL offer link is not present on Home Page");
    }

    public void clickFlight() {
        flight.click();
    }
}

