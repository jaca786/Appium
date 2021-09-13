package screens.nativeapp;

import base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class FlightSearch extends ScreenBase {

    public FlightSearch(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(className = "android.widget.TextView")
    private List<WebElement> tripOptions;

    @AndroidFindBy(id = "com.makemytrip:id/from_city_ow")
    private WebElement cityFrom;

    @AndroidFindBy(id = "com.makemytrip:id/et_from_search")
    private WebElement fromSearchInputText;

    @AndroidFindBy(id = "com.makemytrip:id/et_to_search")
    private WebElement toSearchInputText;

    @AndroidFindBy(id = "com.makemytrip:id/iv_traveller")
    private WebElement traveller;

    @AndroidFindBy(id = "com.makemytrip:id/offerview")
    private WebElement doneButton;

    @AndroidFindBy(id = "com.makemytrip:id/search_button_flat")
    private WebElement searchFlightButton;

    public void selectTrip(String trip) {
        for(int j=0;j<tripOptions.size();j++){
            if(tripOptions.get(j).getText().equals(trip)){
                tripOptions.get(j).click();
                break;
            }
        }
    }

    public void selectDepartureCity(String departureCity) {
        cityFrom.click();
        fromSearchInputText.sendKeys(departureCity);
        driver.hideKeyboard();

        for (WebElement city: tripOptions) {
            if(city.getText().equals(departureCity)) {
                city.click();
                break;
            }
        }
    }

    public void selectArrivalCity(String arrivalCity) {
        toSearchInputText.sendKeys(arrivalCity);
        driver.hideKeyboard();

        for (WebElement toCity: tripOptions) {
            if(toCity.getText().equals(arrivalCity)) {
                toCity.click();
                break;
            }
        }
    }

    public void travellerDetails() {
        traveller.click();
        doneButton.click();
    }

    public void validatesearchFlightTab() {
        Assert.assertTrue(searchFlightButton.isDisplayed(),"search flight button/tab is not present in search Flight page");
    }

}
