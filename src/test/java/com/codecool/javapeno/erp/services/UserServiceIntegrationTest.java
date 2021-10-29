package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.entities.UserPrivilege;
import com.codecool.javapeno.erp.entities.UserStatus;
import com.codecool.javapeno.erp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

//@ContextConfiguration
@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    private User user;
    private UUID uuid;

    @BeforeEach
    void initTests() {
        uuid = UUID.randomUUID();
        user = new User();

        user.setId(uuid);
        user.setName("Test person");
        user.setEmail("test@test.com");
        user.setStatus(UserStatus.ACTIVE);
        user.setPrivilege(UserPrivilege.USER);
    }

    @Test
    void addNewUser_addsNewUser() {
        userService.addNewUser(user);
        assertDoesNotThrow(() -> userService.addNewUser(user));
        assertNotNull(userService.addNewUser(user));
    }

    @Test
    void getUserById_returnsUserIfValidId() {
        User savedUser = userService.addNewUser(user);
        System.out.println("user added");
        assertDoesNotThrow(() -> userService.getUserById(savedUser.getId()));
        assertEquals(userService.getUserById(savedUser.getId()), savedUser);
    }

    @Test
    void updateUserById_updatesUserIfValidId() {
        User savedUser = userService.addNewUser(user);
        System.out.println("user added");
        assertDoesNotThrow(() -> userService.updateUserById(savedUser.getId(), user));
        assertNotNull(userService.updateUserById(savedUser.getId(), savedUser));
    }

    @Test
    void getAllUsers_returnsAllUsers() {
        Pageable pageable = PageRequest.of(0, 10);
        assertDoesNotThrow(() -> userService.getAllUsers(pageable));
        assertNotNull(userService.getAllUsers(pageable));
    }

    @Test
    void deactivateUser_setsUserStatusDeletedIfValidId() {

    }

    @Test
    void getHolidaysByIdInRange_getsHolidaysInRangeIfValidId() {

    }

    @Test
    void addHolidayToUser_addsHolidayIfValidId() {

    }


}
