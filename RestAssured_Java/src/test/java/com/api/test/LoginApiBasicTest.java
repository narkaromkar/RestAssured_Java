package com.api.test;


import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoginApiBasicTest {

    @Test(description = "Verify Login API is working")
    public void loginTest() {
        Response response = given()
                .baseUri("https://dummyjson.com")
                .header("Content-Type", "application/json")
                .body("""
                           {
                            "username": "emilys",
                            "password": "emilyspass",
                            "expiresInMins": 30
                           }
                        """)
                .post("/auth/login");

        assertEquals( response.getStatusCode(),200);
    }
}
