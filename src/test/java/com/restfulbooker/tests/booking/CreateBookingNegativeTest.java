package com.restfulbooker.tests.booking;

import com.restfulbooker.base.BaseTest;
import com.restfulbooker.clients.BookingClient;
import com.restfulbooker.dataproviders.BookingDataProvider;
import com.restfulbooker.exceptions.ApiTestException;
import com.restfulbooker.models.Booking;
import com.restfulbooker.models.BookingDates;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CreateBookingNegativeTest extends BaseTest {

    private final BookingClient bookingClient = new BookingClient();

    @Test(dataProvider = "invalidBookings", dataProviderClass = BookingDataProvider.class,
            description = "Create booking with invalid data expects 500")
    public void testCreateInvalidBooking(String firstname, String lastname, int totalprice) {
        Booking invalid = Booking.builder()
                .firstname(firstname)
                .lastname(lastname)
                .totalprice(totalprice)
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin("2026-01-01")
                        .checkout("2026-01-02")
                        .build())
                .additionalneeds("None")
                .build();

        Response response = bookingClient.createBookingRaw(invalid);

        if (response.statusCode() != 500) {
            throw new ApiTestException(
                    String.format("Expected 500 for invalid booking [%s,%s,%d] but got %d",
                            firstname, lastname, totalprice, response.statusCode())
            );
        }
    }
}