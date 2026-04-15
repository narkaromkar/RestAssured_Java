package com.api.test;


import static io.restassured.RestAssured.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoginApiTest {

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
        System.out.println(response.asPrettyString());

        Assert.assertEquals(200, response.getStatusCode());
    }
}
