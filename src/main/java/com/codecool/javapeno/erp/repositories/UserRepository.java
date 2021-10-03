package com.codecool.javapeno.erp.repositories;

import com.codecool.javapeno.erp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAll();

    Optional<User> findById(@Param("id") UUID id);
}
