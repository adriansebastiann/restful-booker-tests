package com.restfulbooker.utils;

import com.restfulbooker.models.Booking;
import com.restfulbooker.models.BookingDates;

public class TestDataGenerator {
    public static Booking validBooking() {
        return Booking.builder()
                .firstname("John")
                .lastname("Doe")
                .totalprice(150)
                .depositpaid(true)
                .bookingdates(BookingDates.builder()
                        .checkin("2026-05-10")
                        .checkout("2026-05-15")
                        .build())
                .additionalneeds("Breakfast")
                .build();
    }
}