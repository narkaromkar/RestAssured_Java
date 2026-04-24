package com.api.base;

import io.restassured.response.Response;

public class ProductsService extends BaseService{
    private static final String BASE_PATH = "/products/";

    public Response getProducts(String endpoint) {
        return this.fetch(BASE_PATH+endpoint);
    }

}
