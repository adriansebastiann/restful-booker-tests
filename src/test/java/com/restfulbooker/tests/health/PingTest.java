package com.restfulbooker.tests.health;

import com.restfulbooker.clients.BaseClient;
import com.restfulbooker.constants.Endpoints;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PingTest extends BaseClient {

    @Test(description = "Health check")
    public void healthCheck() {
        var response = given().get(Endpoints.PING);
        assertThat(response.statusCode()).isEqualTo(201);
    }
}