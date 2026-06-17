package com.practice.api.base;

import io.restassured.response.Response;

public class AuthService extends BaseService {
    private static final String BASE_PATH = "/auth/";

    public Response login(String endpoint, Object body) {
        return this.post(BASE_PATH+endpoint, body);
    }

    public Response getMe(String endpoint, String token) {
        return this.fetch(BASE_PATH+endpoint, token);
    }
}
