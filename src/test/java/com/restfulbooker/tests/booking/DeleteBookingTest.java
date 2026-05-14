package com.restfulbooker.tests.booking;

import com.restfulbooker.base.BaseTest;
import com.restfulbooker.clients.BookingClient;
import com.restfulbooker.models.BookingResponse;
import com.restfulbooker.utils.TestDataGenerator;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBookingTest extends BaseTest {

    private final BookingClient bookingClient = new BookingClient();

    @Test(description = "Delete a booking and verify it no longer exists")
    public void testDeleteBooking() {
        BookingResponse created = bookingClient.createBooking(TestDataGenerator.validBooking());
        bookingClient.deleteBooking(created.getBookingid(), authToken);

        var response = bookingClient.getBookingRaw(created.getBookingid());
        assertThat(response.statusCode()).isEqualTo(404);
    }
}