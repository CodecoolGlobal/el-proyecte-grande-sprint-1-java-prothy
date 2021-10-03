package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.Holiday;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.codecool.javapeno.erp.entities.User;
import com.codecool.javapeno.erp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns given user's info
     *
     * @param id user id
     * @return the selected user's data
     */
    @GetMapping({"/{id}"})
    public User getUserById(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    /**
     * Updates given users
     *
     * @param id              user id
     * @param updatedUserData must contain the following information
     *                        <ul>
     *                            <li>name</li>
     *                            <li>email (in valid format)</li>
     *                            <li>status ("ACTIVE", "INACTIVE", "HOLIDAY", "SICK")</li>
     *                            <li>privilege ("USER", "SUPER_USER", "ADMIN")</li>
     *                        </ul>
     * @return Updated user
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable UUID id, @RequestBody User updatedUserData) {
        return userService.updateUserById(id, updatedUserData);
    }

    /**
     * Sets given user as inactive in DB
     *
     * @param id user id
     */
    @DeleteMapping("/{id}")
    public void deactivateUser(@PathVariable UUID id) {
        userService.deactivateUser(id);
    }

    /**
     * Adds a new user to database
     *
     * @param user User object in request body must contain following fields:
     *             <ul>
     *                 <li>name</li>
     *                 <li>email (in valid format)</li>
     *                 <li>status ("ACTIVE", "INACTIVE", "HOLIDAY", "SICK")</li>
     *                 <li>privilege ("USER", "SUPER_USER", "ADMIN")</li>
     *             </ul>
     */
    @PostMapping("/add")
    public void addNewUser(@RequestBody User user) {
        userService.addNewUser(user);
    }

    /**
     * Approve modification of given user
     *
     * @deprecated
     */
    @PostMapping("/approve")
    public void approveUpdatedUser(@RequestBody User modifiedUser,
                                   @RequestBody boolean approved) {
        if (approved) userService.updateUser(modifiedUser);
    }

    /**
     * @param id       user id
     * @param dateFrom date range from (optional), e.g. 1990-01-01
     * @param dateTo   date range to (optional)
     * @return list of holidays that overlap with given range
     */
    @GetMapping("/{id}/holidays")
    public List<Holiday> getHolidayByUserId(@PathVariable UUID id,
                                            @RequestParam(name = "from", required = false)
                                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                    LocalDate dateFrom,
                                            @RequestParam(name = "to", required = false)
                                            @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                    LocalDate dateTo) {
        return userService.getHolidaysByIdInRange(id, dateFrom, dateTo);
    }

    @PostMapping("/{id}/holidays/add")
    public void addHolidayToUser(@PathVariable UUID id,
                                 @RequestBody Holiday holiday) {
        userService.addHolidayToUser(id, holiday);
    }

    /**
     * @return All users saved in DB.
     */
    @GetMapping("/all")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}
