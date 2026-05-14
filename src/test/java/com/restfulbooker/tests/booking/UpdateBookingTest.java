package com.restfulbooker.tests.booking;

import com.restfulbooker.base.BaseTest;
import com.restfulbooker.clients.BookingClient;
import com.restfulbooker.models.BookingResponse;
import com.restfulbooker.utils.TestDataGenerator;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateBookingTest extends BaseTest {

    private final BookingClient bookingClient = new BookingClient();

    @Test(description = "Update an existing booking")
    public void testUpdateBooking() {
        BookingResponse created = bookingClient.createBooking(TestDataGenerator.validBooking());
        var updatedData = TestDataGenerator.validBooking();
        updatedData.setFirstname("Updated");
        updatedData.setLastname("User");

        var updated = bookingClient.updateBooking(created.getBookingid(), updatedData, authToken);

        assertThat(updated.getFirstname()).isEqualTo("Updated");
        assertThat(updated.getLastname()).isEqualTo("User");
    }
}