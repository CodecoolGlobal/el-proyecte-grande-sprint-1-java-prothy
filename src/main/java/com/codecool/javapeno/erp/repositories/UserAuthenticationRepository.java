package com.codecool.javapeno.erp.repositories;

import com.codecool.javapeno.erp.entities.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication, UUID> {

    UserAuthentication findByUserId(UUID userId);

    UserAuthentication findByUsername(String username);
}
