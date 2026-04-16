package com.api.base;

import com.api.models.LoginRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {
    private static final String BASE_PATH = "/auth/";

    public Response login(String endpoint, Object body) {
        return this.post(BASE_PATH+endpoint, body);
    }

}
