package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.UserAuthentication;
import com.codecool.javapeno.erp.repositories.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService {

    private final UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    public UserAuthenticationService(UserAuthenticationRepository userAuthenticationRepository) {
        this.userAuthenticationRepository = userAuthenticationRepository;
    }

    public void registerAuthentication(UserAuthentication userAuthentication) {
        userAuthenticationRepository.save(userAuthentication);
    }
}
