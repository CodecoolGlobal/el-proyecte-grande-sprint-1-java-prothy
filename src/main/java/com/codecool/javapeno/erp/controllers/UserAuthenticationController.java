package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.UserAuthentication;
import com.codecool.javapeno.erp.services.UserAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user-authentication-service")
@RequiredArgsConstructor
public class UserAuthenticationController {
    private final UserAuthenticationService userAuthenticationService;

    @PostMapping(path = "/register")
    public void registerAuthentication(@RequestBody UserAuthentication userAuthentication) {
        userAuthenticationService.registerAuthentication(userAuthentication);
    }
}
