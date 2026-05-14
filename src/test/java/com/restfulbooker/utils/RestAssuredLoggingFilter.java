package com.restfulbooker.utils;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class RestAssuredLoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(RestAssuredLoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
        logger.debug("Request body: {}", Optional.ofNullable(requestSpec.getBody()));
        Response response = ctx.next(requestSpec, responseSpec);
        logger.info("Response status: {}", response.getStatusCode());
        logger.debug("Response body: {}", response.getBody().asPrettyString());
        return response;
    }
}