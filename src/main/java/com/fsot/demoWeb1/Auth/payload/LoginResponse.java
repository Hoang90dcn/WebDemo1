package com.fsot.demoWeb1.Auth.payload;

import lombok.Data;

@Data
public class LoginResponse {
    private String userName;
    private String accessToken=null;
    private String tokenType = "Bearer";

    public LoginResponse(String userName, String accessToken) {
        this.userName = userName;
        this.accessToken = accessToken;
    }
}
