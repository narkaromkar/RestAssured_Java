package com.practice.api.base;

import io.restassured.response.Response;

public class ProductsService extends BaseService{
    private static final String BASE_PATH = "/products/";

    public Response getProducts(String endpoint) {
        return this.fetch(BASE_PATH+endpoint);
    }

    public Response addProducts(String endpoint, Object body) {
        return this.post(BASE_PATH+endpoint, body);
    }

}
