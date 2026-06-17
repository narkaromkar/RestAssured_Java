package com.practice.api.test;


import com.practice.api.models.LoginRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class LoginApiBasicUsingPOJOTest {

    @Test(description = "Verify Login API is working")
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest("iamfd","password");

        Response response =
                given()
                        .baseUri("http://64.227.160.186:9000/v1")
                        .contentType(ContentType.JSON)     //using enum instead hardcoded .header("Content-Type", "application/json")
                        .body(loginRequest) //serialization using POJO
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
