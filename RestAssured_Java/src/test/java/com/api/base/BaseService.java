package com.api.base;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.response.Response;

public class BaseService {
    private static final String BASE_URI = "https://dummyjson.com";

    public RequestSpecification baseRequestSpec() {
        return given().baseUri(BASE_URI);
    }
    
    public Response post(String endpoint, String body) {
        return baseRequestSpec()
            .contentType(ContentType.JSON)
            .body(body)
            .post(endpoint);
    } 

}
