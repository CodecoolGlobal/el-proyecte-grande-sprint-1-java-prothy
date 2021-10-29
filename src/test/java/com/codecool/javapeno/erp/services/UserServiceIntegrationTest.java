package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.entities.UserPrivilege;
import com.codecool.javapeno.erp.entities.UserStatus;
import com.codecool.javapeno.erp.repositories.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration
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
        uuid = UUID.fromString("2b593973-a87e-4653-b1cf-e337f34b3cb3");
        user = new User();

        user.setId(uuid);
        user.setName("Test person");
        user.setEmail("test@test.com");
        user.setStatus(UserStatus.ACTIVE);
        user.setPrivilege(UserPrivilege.USER);
    }

    @Test
    @Transactional
    void addNewUser_addsNewUser() {
        userService.addNewUser(user);
        assertDoesNotThrow(() -> userService.addNewUser(user));
        assertNotNull(userService.addNewUser(user));
    }

    @Test
    @Transactional
    void getUserById_returnsUserIfValidId() {
        userService.addNewUser(user);
        System.out.println("user added");
        assertDoesNotThrow(() -> userService.getUserById(uuid));
        assertEquals(userService.getUserById(uuid), user);
    }

    @Test
    @Transactional
    void updateUserById_updatesUserIfValidId() {
        userService.addNewUser(user);
        System.out.println("user added");
        assertDoesNotThrow(() -> userService.updateUserById(uuid, user));
        assertNotNull(userService.updateUserById(uuid, user));
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
