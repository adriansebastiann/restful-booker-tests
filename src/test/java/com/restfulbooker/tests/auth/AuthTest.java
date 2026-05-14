package com.restfulbooker.tests.auth;

import com.restfulbooker.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest extends BaseTest {

    @Test(description = "Valid authentication")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a valid token is returned for correct credentials")
    public void testSuccessfulAuthentication() {
        assertThat(authToken)
                .isNotNull()
                .isNotEmpty();
    }
}