package com.restfulbooker.base;

import com.restfulbooker.clients.AuthClient;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {

    protected static String authToken;
    protected final AuthClient authClient = new AuthClient();
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    @Step("Obtain authentication token")
    public void globalSetup() {
        logger.info("Authenticating...");
        var response = authClient.authenticate("admin", "password123");
        authToken = response.getToken();
        logger.info("Token obtained: {}", authToken);
    }

    @AfterSuite(alwaysRun = true)
    public void globalTearDown() {
        // cleanup
    }
}