package com.practice.api.test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class DemoTest {
    public static void main(String[] args){
        RestAssured.baseURI = "https://www.google.com";

        Response response = RestAssured
                .given()
                .header("Accept", "*/*")
                .get();

        System.out.println(response.getBody().asPrettyString());
        System.out.println(response.time());
        System.out.println(response.statusCode());

    }
}
