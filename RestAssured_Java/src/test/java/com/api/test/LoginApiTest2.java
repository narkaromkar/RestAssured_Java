package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.BaseService;
import io.restassured.response.Response;

public class LoginApiTest2 {

    @Test(description = "Verify Login API is working")
    public void loginTest() {
        AuthService authService = new AuthService();
        Response response = authService.login("login", """
                           {
                            "username": "emilys",
                            "password": "emilyspass",
                            "expiresInMins": 30
                           }
                        """);
        System.out.println(response.asPrettyString());

        Assert.assertEquals(200, response.getStatusCode());
    }
}
