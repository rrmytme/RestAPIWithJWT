package org.RestWithJWT.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/api/user/profile")
    public String userProfile() {
        return "This is a secure profile page!";
    }
}

