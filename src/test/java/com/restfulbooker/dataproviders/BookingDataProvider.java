package com.restfulbooker.dataproviders;

import org.testng.annotations.DataProvider;

public class BookingDataProvider {

    @DataProvider(name = "invalidBookings")
    public static Object[][] invalidBookings() {
        return new Object[][]{
                {"", "Doe", 150},
                {"John", "", 150},
                {"John", "Doe", -1}
        };
    }
}