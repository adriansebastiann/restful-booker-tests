package com.restfulbooker.clients;

import com.restfulbooker.config.Configuration;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class BaseClient {

    static {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    protected RequestSpecification given() {
        return RestAssured.given()
                .baseUri(Configuration.getBaseUri())
                .contentType("application/json")
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());
    }
}