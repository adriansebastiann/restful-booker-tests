package com.restfulbooker.clients;

import com.restfulbooker.constants.Endpoints;
import com.restfulbooker.models.AuthRequest;
import com.restfulbooker.models.AuthResponse;

public class AuthClient extends BaseClient {
    public AuthResponse authenticate(String username, String password) {
        AuthRequest request = new AuthRequest(username, password);
        return given()
                .body(request)
                .when()
                .post(Endpoints.AUTH)
                .then()
                .statusCode(200)
                .extract().as(AuthResponse.class);
    }
}