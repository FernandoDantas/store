package com.product.store.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public void login() {
        // This method can be left empty because Spring Security will handle the authentication
    }
}
