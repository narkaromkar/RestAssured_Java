package com.practice.api.test;


import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class LoginApiBasicTest {

    @Test(description = "Verify Login API is working")
    public void loginTest() {
        Map<String, String> payload = new HashMap<String, String>();
        payload.put("username", "iamfd");
        payload.put("password", "password");


        Response response =
                given()
                        .baseUri("http://64.227.160.186:9000/v1")
                        .contentType(ContentType.JSON)     //using enum instead hardcoded .header("Content-Type", "application/json")
//                       .body("""
//                                  {
//                                    "username": "iamfd",
//                                    "password": "password"
//                                  }
//                                  """)
                        //using map with serialization instead above hardcoded payload
                        .body(payload)
                        .accept(ContentType.JSON)   // only accept JSON response
                        .log().all()
                .when()
                    .post("login")
                .then()
                        .log().all()
                        .statusCode(200)
                        .extract().response();

        assertEquals( response.getStatusCode(),200);
        System.out.println(response.getBody().asPrettyString());
    }
}
