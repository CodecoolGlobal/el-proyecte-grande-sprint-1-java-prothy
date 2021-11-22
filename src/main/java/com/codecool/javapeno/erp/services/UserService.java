package com.codecool.javapeno.erp.services;

import com.codecool.javapeno.erp.entities.Holiday;
import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.entities.UserStatus;
import com.codecool.javapeno.erp.repositories.HolidayRepository;
import com.codecool.javapeno.erp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final HolidayRepository holidayRepository;
    private final UserAuthenticationService userAuthenticationService;
    private final EmailSenderService emailSenderService;

    @Autowired
    public UserService(UserRepository userRepository, HolidayRepository holidayRepository,
                       EmailSenderService emailSenderService,
                       UserAuthenticationService userAuthenticationService) {
        this.userRepository = userRepository;
        this.holidayRepository = holidayRepository;
        this.emailSenderService = emailSenderService;
        this.userAuthenticationService = userAuthenticationService;
    }

    public User getUserById(UUID userId) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if (maybeUser.isEmpty()) {
            throw new NoSuchElementException("There is no such a user!");
        }
        return maybeUser.get();
    }

    public String updateUserById(UUID userId, User updatedUserData) {
        Optional<User> maybeUser = userRepository.findById(userId);
        if (maybeUser.isEmpty()) {
            throw new NoSuchElementException("There is no such a user!");
        }
        updatedUserData.setId(userId);
        userRepository.save(updatedUserData);
        return "User data updated";
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public String addNewUser(User user) {
        userRepository.save(user);
        userAuthenticationService.createAuthenticationByUser(user);
        emailSenderService.sendEmail(user);
        return "New user saved";
    }

    public String deactivateUser(UUID id) {
        Optional<User> maybeUser = userRepository.findById(id);
        if (maybeUser.isEmpty()) {
            throw new NoSuchElementException("There is no such a user!");
        }
        User user = maybeUser.get();
        user.setStatus(UserStatus.DELETED);
        userRepository.save(user);
        return "User deactivated";
    }

    public String updateUser(User updatedUser) {
        Optional<User> maybeUser = userRepository.findById(updatedUser.getId());
        if (maybeUser.isEmpty()) {
            throw new NoSuchElementException("There is no such a user!");
        }
        User user = maybeUser.get();

        userRepository.save(updatedUser);

        return "User data change approved";
    }

    public List<Holiday> getHolidaysByIdInRange(UUID userId, LocalDate from, LocalDate to) {
        if (userRepository.findById(userId).isEmpty()) throw new NoSuchElementException("There is no such a user!");
        if (from == null && to == null) return holidayRepository.findAllByUserId(userId);

        if (from == null) from = LocalDate.of(1970, 1, 1);
        if (to == null) to = LocalDate.now();

        return holidayRepository.findAllByUserIdBetween(userId, from, to);
    }

    public String addHolidayToUser(UUID userId, Holiday holiday) {
        User user = getUserById(userId);
        holiday.setUser(user);
        holidayRepository.save(holiday);
        return "New holiday added";
    }
}
