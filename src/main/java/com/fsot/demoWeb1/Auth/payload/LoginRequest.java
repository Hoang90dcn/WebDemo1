package com.fsot.demoWeb1.Auth.payload;

import lombok.Data;

@Data
public class LoginRequest {

    private String username;


    private String password;
}
