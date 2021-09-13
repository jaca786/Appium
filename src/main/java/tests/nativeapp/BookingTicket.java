package tests.nativeapp;

import base.BaseTest;
import org.testng.annotations.Test;

public class BookingTicket extends BaseTest {

    @Test
    public void bookTicket() throws InterruptedException {
        mmt.loginSelection();
        mmt.login("9599508089");
        homePage.validateOfferLink();
        homePage.clickFlight();
        flightSearch.selectTrip("ROUNDTRIP");
        flightSearch.selectDepartureCity("Pune");
        flightSearch.selectArrivalCity("New Delhi");
        flightSearch.travellerDetails();
        flightSearch.validatesearchFlightTab();
    }
}
