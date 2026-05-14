package com.restfulbooker.tests.booking;

import com.restfulbooker.base.BaseTest;
import com.restfulbooker.clients.BookingClient;
import com.restfulbooker.models.BookingResponse;
import com.restfulbooker.utils.TestDataGenerator;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingTest extends BaseTest {

    private final BookingClient bookingClient = new BookingClient();

    @Test(description = "Get booking by existing ID")
    public void testGetBookingById() {
        BookingResponse created = bookingClient.createBooking(TestDataGenerator.validBooking());
        var fetched = bookingClient.getBooking(created.getBookingid());

        assertThat(fetched)
                .usingRecursiveComparison()
                .ignoringFields("depositpaid", "additionalneeds")
                .isEqualTo(created.getBooking());
    }

    @Test(description = "Get booking with non‑existent ID returns 404")
    public void testGetNonExistentBooking() {
        var response = bookingClient.getBookingRaw(999999);
        assertThat(response.statusCode()).isEqualTo(404);
    }
}