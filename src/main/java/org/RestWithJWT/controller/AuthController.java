package org.RestWithJWT.controller;

import org.RestWithJWT.Model.AuthRequest;
import org.RestWithJWT.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        if ("admin".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
            return JwtUtil.generateToken(authRequest.getUsername());
        }
        throw new RuntimeException("Invalid Credentials");
    }
}


