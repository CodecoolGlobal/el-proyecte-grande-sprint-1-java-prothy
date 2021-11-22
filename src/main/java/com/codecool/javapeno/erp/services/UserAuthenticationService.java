package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.entities.UserAuthentication;
import com.codecool.javapeno.erp.models.PasswordChangeModel;
import com.codecool.javapeno.erp.repositories.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserAuthenticationService implements UserDetailsService {
    private final UserAuthenticationRepository userAuthenticationRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserAuthenticationService(UserAuthenticationRepository userAuthenticationRepository,
                                     PasswordEncoder passwordEncoder) {
        this.userAuthenticationRepository = userAuthenticationRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAuthentication userAuthentication = getAuthenticationByUsername(username);
        User user;


        if (userAuthentication == null) {
            throw new UsernameNotFoundException("User not found in the database");
        } else user = userAuthentication.getUser();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getPrivilege().toString()));

        return new org.springframework.security.core.userdetails.User(
                userAuthentication.getUsername(),
                userAuthentication.getPassword(),
                authorities);
    }

    public User getUserByUsername(String name) {
        return userAuthenticationRepository.findByUsername(name).getUser();
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

    public void createAuthenticationByUser(User user) {
        String randomPassword = UUID.randomUUID().toString();
        UserAuthentication userAuthentication = new UserAuthentication(user, passwordCoder(randomPassword));
        registerAuthentication(userAuthentication);
    }

    public UserAuthentication getAuthenticationByUsername(String userName) {
        return userAuthenticationRepository.findByUsername(userName);
    }

    private String passwordCoder(String hashedPassword) {
        return passwordEncoder.encode(hashedPassword);
    }
}
