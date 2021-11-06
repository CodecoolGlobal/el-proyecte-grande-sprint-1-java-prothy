package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.Holiday;
import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.repositories.HolidayRepository;
import com.codecool.javapeno.erp.repositories.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private HolidayRepository holidayRepository;

    @InjectMocks
    private UserService userService;

    private UUID uuid;
    private User user;

    @BeforeEach
    void initTest() {
        uuid = UUID.randomUUID();
        user = new User();
    }

    @Nested
    class Positive {
        @BeforeEach
        void initPositiveTest() {
            when(userRepository.findById(uuid)).thenReturn(Optional.of(user));
        }


        @Test
        void getUserById_returnsUserIfExistsInDb() {
            User foundUser = userService.getUserById(uuid);

            assertEquals(foundUser, user);
        }

        @Test
        void updateUserById_returnsValueIfSuccessful() {
            when(userRepository.save(user)).thenReturn(user);

            assertNotNull(userService.updateUserById(uuid, user));
            assertDoesNotThrow(() -> userService.updateUserById(uuid, user));
        }

        @Test
        void deactivateUser_returnsValueIfSuccessful() {
            assertNotNull(userService.deactivateUser(uuid));
            assertDoesNotThrow(() -> userService.deactivateUser(uuid));
        }

        @Test
        void getHolidaysByIdInRange_returnsValueIfSuccessful() {
            LocalDate from = LocalDate.of(1970, 1, 1);
            LocalDate to = LocalDate.now();

            assertNotNull(userService.getHolidaysByIdInRange(uuid, from, to));
            assertDoesNotThrow(() -> userService.getHolidaysByIdInRange(uuid, from, to));

            assertNotNull(userService.getHolidaysByIdInRange(uuid, from, null));
            assertDoesNotThrow(() -> userService.getHolidaysByIdInRange(uuid, from, null));

            assertNotNull(userService.getHolidaysByIdInRange(uuid, null, to));
            assertDoesNotThrow(() -> userService.getHolidaysByIdInRange(uuid, null, to));
        }

        @Test
        void addHolidayToUser_returnsValueIfSuccessful() {
            Holiday holiday = new Holiday();

            assertNotNull(userService.addHolidayToUser(uuid, holiday));
            assertDoesNotThrow(() -> userService.addHolidayToUser(uuid, holiday));
        }
    }

    @Nested
    class Negative {
        @BeforeEach
        void initNegativeTest() {
            when(userRepository.findById(uuid)).thenReturn(Optional.empty());
        }

        @Test
        void getUserById_throwsExceptionIfNotFoundInDb() {
            assertThrows(NoSuchElementException.class, () -> userService.getUserById(uuid));
        }

        @Test
        void updateUserById_throwsExceptionIfNotFoundInDb() {
            assertThrows(NoSuchElementException.class, () -> userService.updateUserById(uuid, user));
        }

        @Test
        void deactivateUser_throwsExceptionIfNotFoundInDb() {
            assertThrows(NoSuchElementException.class, () -> userService.deactivateUser(uuid));
        }

        @Test
        void getHolidaysByIdInRange_throwsExceptionIfNotFoundInDb() {
            LocalDate from = LocalDate.of(1970, 1, 1);
            LocalDate to = LocalDate.now();

            assertThrows(NoSuchElementException.class, () -> userService.getHolidaysByIdInRange(uuid, from, to));
        }

        @Test
        void addHolidayToUser_throwsExceptionIfNotFoundInDb() {
            Holiday holiday = new Holiday();

            assertThrows(NoSuchElementException.class, () -> userService.addHolidayToUser(uuid, holiday));
        }
    }
}