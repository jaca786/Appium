package screens.nativeapp;

import base.Constants;
import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookingFlights extends ScreenBase {

    public BookingFlights(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id=Constants.NONE_LOGIN_SELECTION)
    public List<WebElement> loginSelectionCancel;

    @AndroidFindBy(id="com.makemytrip:id/textinput_placeholder")
    public WebElement inputLoginText;

    @AndroidFindBy(id="com.makemytrip:id/btn_continue")
    public WebElement continueButton;

    public void loginSelection() {
        Boolean isPresent = loginSelectionCancel.size() > 0;
        if(isPresent) {
            waitForElement(15, Constants.NONE_LOGIN_SELECTION);
            loginSelectionCancel.get(0).click();
        }
    }

    public void login(String mobileNumber) throws InterruptedException {
        inputLoginText.sendKeys(mobileNumber);
        continueButton.click();
        Thread.sleep(25000); // OTP is being used for login on MMT application, so this needs to be entered manually in this time frame
        continueButton.click();
    }

}
