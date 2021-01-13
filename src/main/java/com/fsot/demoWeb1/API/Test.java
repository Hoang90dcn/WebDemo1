package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.Auth.JWT.JwtTokenProvider;
import com.fsot.demoWeb1.Auth.User.CustomUserDetails;
import com.fsot.demoWeb1.Auth.payload.LoginRequest;
import com.fsot.demoWeb1.Auth.payload.LoginResponse;
import com.fsot.demoWeb1.Auth.payload.RandomStuff;
import com.fsot.demoWeb1.Repo.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class Test {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {

        System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);


        // Trả về jwt cho người dùng.
        String jwt = null;
        jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        System.out.println(jwt);
        System.out.println( tokenProvider.validateToken(jwt));

        if(tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal()).length()==0){
            System.out.println("nooo");
        }
        return ResponseEntity.ok(new LoginResponse(jwt));
    }






}
