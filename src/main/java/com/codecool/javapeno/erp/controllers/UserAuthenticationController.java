package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.UserAuthentication;
import com.codecool.javapeno.erp.models.PasswordChangeModel;
import com.codecool.javapeno.erp.services.UserAuthenticationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/first-password-change")
    @ApiOperation(
            value = "Change users password for the first time",
            notes = "Change users password for the first time")
    public void userFirstPasswordChange(
            @ApiParam(value = "Users email and new password", required = true)
            @RequestBody PasswordChangeModel passwordChangeModel) {
        userAuthenticationService.changeUsersPassword(passwordChangeModel);
    }
}
