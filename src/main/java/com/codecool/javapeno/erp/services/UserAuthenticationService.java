package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.UserAuthentication;
import com.codecool.javapeno.erp.models.PasswordChangeModel;
import com.codecool.javapeno.erp.repositories.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

    private final UserAuthenticationRepository userAuthenticationRepository;
    private final UserService userService;

    @Autowired
    public UserAuthenticationService(UserAuthenticationRepository userAuthenticationRepository,
                                     UserService userService) {
        this.userAuthenticationRepository = userAuthenticationRepository;
        this.userService = userService;
    }

    public void registerAuthentication(UserAuthentication userAuthentication) {
        userAuthenticationRepository.save(userAuthentication);
    }

    public void changeUsersPassword(PasswordChangeModel passwordChangeModel) {
        String hashedPassword = passwordCoder(passwordChangeModel.getPassword());
        // UserAuthentication userAuthentication = userAuthenticationRepository.findByUserId(passwordChangeModel.getUserId());
        // userAuthentication.setPassword(hashedPassword);
        // registerAuthentication(userAuthentication);
    }

    private String passwordCoder(String hashedPassword) {
        return hashedPassword;
        // return passwordEncoder.encode(hashedPassword);
    }
}
