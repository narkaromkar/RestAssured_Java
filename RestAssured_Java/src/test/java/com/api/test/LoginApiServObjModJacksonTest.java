package com.api.test;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.LoginRequest;
import com.api.models.LoginResponse;
import io.restassured.response.Response;

public class LoginApiServObjModJacksonTest {

    @Test(description = "Verify Login API is working and tokens exist")
    public void loginTest() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("emilys","emilyspass",30);
        //we are using serialization here, so we are passing the object directly and Jackson will convert it to json
        Response response = authService.login("login", loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class); //deserialization, we are converting the json response to java object

        assertNotNull(loginResponse.getAccessToken(), "Access Token is null");
        assertNotNull(loginResponse.getRefreshToken(), "Refresh Token is null");
    }

    @Test(description = "Verify getting user details working")
    public void getLoggedInUserTest() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("emilys","emilyspass",30);
        Response response = authService.login("login", loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        String accessToken = loginResponse.getAccessToken();

        assertNotNull(accessToken, "Access Token is null");
        Response getMeResponse = authService.getMe("me", accessToken);

        System.out.println(getMeResponse.asPrettyString());
    }
}
