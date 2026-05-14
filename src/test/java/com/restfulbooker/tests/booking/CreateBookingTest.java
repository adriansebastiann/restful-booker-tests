package com.restfulbooker.tests.booking;

import com.restfulbooker.base.BaseTest;
import com.restfulbooker.clients.BookingClient;
import com.restfulbooker.models.Booking;
import com.restfulbooker.models.BookingResponse;
import com.restfulbooker.utils.TestDataGenerator;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Booking Management")
@Feature("Create Booking")
public class CreateBookingTest extends BaseTest {

    private final BookingClient bookingClient = new BookingClient();

    @Test(description = "Create a valid booking")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Creates a booking with valid data and checks the response")
    public void testCreateValidBooking() {
        Booking request = TestDataGenerator.validBooking();
        BookingResponse response = bookingClient.createBooking(request);

        assertThat(response.getBookingid()).isPositive();
        assertThat(response.getBooking())
                .usingRecursiveComparison()
                .ignoringFields("depositpaid", "additionalneeds")
                .isEqualTo(request);
    }
}