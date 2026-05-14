package com.restfulbooker.clients;

import com.restfulbooker.constants.Endpoints;
import com.restfulbooker.models.Booking;
import com.restfulbooker.models.BookingResponse;
import io.restassured.response.Response;

public class BookingClient extends BaseClient {
    public BookingResponse createBooking(Booking booking) {
        return given().body(booking)
                .when().post(Endpoints.BOOKING)
                .then().statusCode(200).extract().as(BookingResponse.class);
    }

    public Booking getBooking(int id) {
        return given()
                .when().get(Endpoints.BOOKING + "/" + id)
                .then().statusCode(200).extract().as(Booking.class);
    }

    public Booking updateBooking(int id, Booking updatedBooking, String token) {
        return given()
                .header("Cookie", "token=" + token)
                .body(updatedBooking)
                .when().put(Endpoints.BOOKING + "/" + id)
                .then().statusCode(200).extract().as(Booking.class);
    }

    public void deleteBooking(int id, String token) {
        given()
                .header("Cookie", "token=" + token)
                .when().delete(Endpoints.BOOKING + "/" + id)
                .then().statusCode(201);
    }

    public Response getBookingRaw(int id) {
        return given().when().get(Endpoints.BOOKING + "/" + id);
    }
}