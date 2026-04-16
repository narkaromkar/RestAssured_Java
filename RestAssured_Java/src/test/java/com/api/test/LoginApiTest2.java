package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.LoginRequest;
import com.api.models.LoginResponse;

import io.restassured.response.Response;

public class LoginApiTest2 {

    @Test(description = "Verify Login API is working")
    public void loginTest() {
        AuthService authService = new AuthService();
        LoginRequest loginRequest = new LoginRequest("emilys","emilyspass",30);
        Response response = authService.login("login", loginRequest); //we are using serailization here, so we are passing the object directly and jackson will convert it to json
        System.out.println(response.asPrettyString());
        LoginResponse loginResponse = response.as(LoginResponse.class); //deserialization, we are converting the json response to java object
        System.out.println(loginResponse.getAccessToken());
        System.out.println(loginResponse.getRefreshToken());
        System.out.println(loginResponse.getId());
        System.out.println(loginResponse.getUsername());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getFirstName());
        System.out.println(loginResponse.getLastName());
        System.out.println(loginResponse.getGender());
        System.out.println(loginResponse.getImage());

        Assert.assertNotNull(loginResponse.getAccessToken());
        Assert.assertEquals(loginResponse.getId(), 1);
    }
}
