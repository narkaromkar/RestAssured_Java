package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.LoginRequest;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class BaseService {
    private static final String BASE_URI = "https://dummyjson.com";

    public RequestSpecification baseRequestSpec() {
        return given()
                .baseUri(BASE_URI)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

    }
    
    public Response post(String endpoint, Object body) {
        return baseRequestSpec()
            .contentType(ContentType.JSON)
            .body(body)
            .post(endpoint);
    }

    public Response fetch(String endpoint) {
        System.out.println("URL"+BASE_URI+endpoint);
        return baseRequestSpec()
                .get(endpoint);
    }

    public Response fetch(String endpoint, String token) {
        System.out.println("URL"+BASE_URI+endpoint);
        return baseRequestSpec()
                .header("Authorization", "Bearer " + token)
                .get(endpoint);
    }
}


