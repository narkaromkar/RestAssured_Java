package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class BaseService {
    private static final String BASE_URI = "https://dummyjson.com";

    public RequestSpecification baseRequestSpec() {
        return given().baseUri(BASE_URI);
    }
    
    public Response post(String endpoint, Object body) {
        return baseRequestSpec()
            .contentType(ContentType.JSON)
            .body(body)
            .post(endpoint);
    }

    public Response fetch(String endpoint) {
        return baseRequestSpec()
                .get(endpoint);
    }
}


