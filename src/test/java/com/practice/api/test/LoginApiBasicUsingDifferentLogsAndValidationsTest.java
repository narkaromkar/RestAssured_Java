package com.practice.api.test;


import com.practice.api.models.LoginRequest;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class LoginApiBasicUsingDifferentLogsAndValidationsTest {

    @Test(description = "Verify Login API is working")
    public void loginTest() {
        LoginRequest loginRequest = new LoginRequest("iamfd","password");

        //below we'll see


        Response response =
                given()
                        .baseUri("http://64.227.160.186:9000/v1")
                        .contentType(ContentType.JSON)     //using enum instead hardcoded .header("Content-Type", "application/json")
                        .body(loginRequest) //serialization using POJO
                        .accept(ContentType.JSON)   // only accept JSON response
                        // using log().all() is not good practice instead use separate methods like below
                        .log().uri()
                        .log().method()
                        .log().headers()
                        .log().body()
                .when()
                    .post("login")
                .then()
                        .log().ifValidationFails() // logs repose logs only if validation fails
                        .statusCode(200)
                        .and()
                        .body("data.token", notNullValue()) //static import of matchers from hamcrest
                        .and()
                        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("responseSchema/loginAPIResponseSchema.json")) //validation of json schema
                        .and()
                        .body("message", equalTo("Success")) //static import of matchers from hamcrest
                        .and()
                        .time(lessThan(1500L)) //L indicates long value and 1500 is milliseconds
                        .extract().response();

        assertEquals( response.getStatusCode(),200);
        System.out.println(response.getBody().asPrettyString());
    }
}
