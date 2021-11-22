package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.models.PasswordChangeModel;
import com.codecool.javapeno.erp.services.UserAuthenticationService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth-service")
@RequiredArgsConstructor
public class UserAuthenticationController {
    private final UserAuthenticationService userAuthenticationService;

    @PostMapping("/first-password-change")
    @ApiOperation(
            value = "Change users password for the first time",
            notes = "Change users password for the first time")
    public void userFirstPasswordChange(
            @ApiParam(value = "Users email and new password", required = true)
            @RequestBody PasswordChangeModel passwordChangeModel) {
        userAuthenticationService.changeUsersPassword(passwordChangeModel);
    }

    @GetMapping("/current-user")
    public User getCurrentUser(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        return userAuthenticationService.getUserByUsername(username);
    }
}
