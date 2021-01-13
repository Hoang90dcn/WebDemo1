package com.fsot.demoWeb1.Auth.payload;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken=null;
    private String tokenType = "Bearer";

    public LoginResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
