package rough;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.DriverMobileCommand;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.AppiumServer;
import utils.CommonUtils;

import java.io.IOException;
import java.util.List;

public class MakeMyTrip {
    public static AppiumDriver driver;
    public static void main(String args[]) throws IOException, InterruptedException {
        AppiumServer.stop();
        AppiumServer.start();

        CommonUtils.loadConfigProp("mmt.properties");
        CommonUtils.setCapabilities();

        driver = CommonUtils.getDriver();

        WebDriverWait wait = new WebDriverWait(driver,20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.makemytrip:id/textinput_placeholder"))).sendKeys("9599508089");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.google.android.gms:id/cancel"))).click();

        //driver.findElement(By.id("com.google.android.gms:id/cancel")).click();
        //if locator present then enter text, otherwise clear
        //driver.findElement(By.id("com.makemytrip:id/textinput_placeholder")).sendKeys("9599508089");
        driver.findElement(By.id("com.makemytrip:id/btn_continue")).click();
        Thread.sleep(25000);
        driver.findElement(By.id("com.makemytrip:id/btn_continue")).click();

        // Below Block is working fine
       /*String header= driver.findElement(By.id("com.makemytrip:id/tv_header")).getText();
       Assert.assertEquals(header,"OFFERS");

       String subHeader = driver.findElement(By.id("com.makemytrip:id/tv_subheader")).getText();
       Assert.assertEquals(subHeader,"Welcome Offers for you, Abhishesh");*/

        //check below block afterwords
        /*WebElement services = driver.findElement(By.className("android.widget.RelativeLayout"));


       List<WebElement> icon = services.findElements(By.id("com.makemytrip:id/title"));
        for (WebElement text:icon) {

            System.out.println("*********************----->>>>>>>" + text.getText());
            //text.click();
            //Thread.sleep(10000);
        }*/

        //driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.ImageView")).click();
        List<WebElement> list = driver.findElements(By.className("android.widget.TextView"));

        for(int x=0;x<list.size();x++) {
            list.get(x).getText();
        }

        Thread.sleep(15000);
        List<WebElement> flightTicket = driver.findElements(By.className("android.widget.TextView"));

        for (WebElement trip: flightTicket) {
            if(trip.getText().equals("ROUNDTRIP")) {
                trip.click();
                break;
            }
        }

        try {
            driver.findElement(By.id("com.makemytrip:id/from_city_ow")).click();
            Thread.sleep(2000);
        }catch (Exception e){
            driver.findElement(By.id("com.makemytrip:id/from_city_ow")).click();
        }


        driver.findElement(By.id("com.makemytrip:id/et_from_search")).sendKeys("Pune");
        driver.hideKeyboard();
        List<WebElement> city = driver.findElements(By.className("android.widget.TextView"));
        //flightTicket.get(3).click();com.makemytrip:id/city_airport_container
        //click first element
        ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout
        ///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout
        for(int i=0;i<city.size();i++){
            if(city.get(i).getText().startsWith("Pune")){
                city.get(i).click();
                break;
            }
        }
        Thread.sleep(10000);
        driver.findElement(By.id("com.makemytrip:id/et_to_search")).sendKeys("Delhi");
        driver.hideKeyboard();
        List<WebElement> cityTo = driver.findElements(By.className("android.widget.TextView"));
        Thread.sleep(2000);
        for(int i=0;i<cityTo.size();i++){
            if(cityTo.get(i).getText().startsWith("New Delhi")){
                cityTo.get(i).click();
                break;
            }
        }

        driver.findElement(By.id("com.makemytrip:id/iv_traveller")).click(); // Adult tab
        driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.RelativeLayout")).click();
        driver.findElement(By.id("com.makemytrip:id/offerview")).click();

        driver.findElement(By.id("com.makemytrip:id/search_button_flat")).click(); //searchFlight
        driver.quit();

    }
}

