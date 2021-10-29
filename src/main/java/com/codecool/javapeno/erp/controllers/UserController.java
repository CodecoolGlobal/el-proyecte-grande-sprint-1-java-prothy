package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.Holiday;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    /**
     * Returns given user's info
     *
     * @param id user id
     * @return the selected user's data
     */
    @GetMapping({"/{id}"})
    @ApiOperation(
            value = "Find user by id",
            notes = "Provide an id to look up specific user from the users book",
            response = User.class)

    public User getUserById(
            @ApiParam(value = "ID value for the user you need to retrieve", required = true)
            @PathVariable UUID id) {

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
    @ApiOperation(
            value = "Update user data by id",
            notes = "Updating user data in the user book",
            response = String.class)

    public String updateUserById(
            @ApiParam(value = "ID value for the user", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "All user data for to update")
            @RequestBody User updatedUserData) {

        return userService.updateUserById(id, updatedUserData);
    }

    /**
     * Sets given user as inactive in DB
     *
     * @param id user id
     */
    @DeleteMapping("/{id}")
    @ApiOperation(
            value = "Deactivate user by id",
            notes = "Change user status to deleted",
            response = String.class)

    public String deactivateUser(
            @ApiParam(value = "Id value for the user", required = true)
            @PathVariable UUID id) {

        return userService.deactivateUser(id);
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
    @ApiOperation(
            value = "Create new user",
            notes = "Add new user to the users book",
            response = String.class)

    public User addNewUser(
            @ApiParam(value = "All parameter for create new user", required = true)
            @RequestBody User user) {

        return userService.addNewUser(user);
    }

    /**
     * Approve modification of given user
     *
     * @deprecated
     */
    @PostMapping("/approve")
    @ApiOperation(
            value = "Approve user data to update",
            notes = "Accept the submitted user data",
            response = String.class)

    public String approveUpdatedUser(
            @ApiParam(value = "User data to modify", required = true)
            @RequestBody User modifiedUser,
            @ApiParam(value = "true/false parameter to accept the modification")
            @RequestBody boolean approved) {
        String message = "User data change not approved";
        if (approved) {
            message = userService.updateUser(modifiedUser);
        }
        return message;
    }

    /**
     * @param id       user id
     * @param dateFrom date range from (optional), e.g. 1990-01-01
     * @param dateTo   date range to (optional)
     * @return list of holidays that overlap with given range
     */
    @GetMapping("/{id}/holidays")
    @ApiOperation(
            value = "Get user holidays by id",
            notes = "Return all user holidays from the holiday book by date",
            response = List.class)

    public List<Holiday> getHolidayByUserId(
            @ApiParam(value = "Id value from the user", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "The Holiday beginning date")
            @RequestParam(name = "from", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateFrom,
            @ApiParam(value = "The Holiday ending date")
            @RequestParam(name = "to", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateTo) {

        return userService.getHolidaysByIdInRange(id, dateFrom, dateTo);
    }

    @PostMapping("/{id}/holidays/add")
    @ApiOperation(
            value = "Add holiday",
            notes = "Add holiday to holiday book by user id",
            response = String.class)

    public String addHolidayToUser(
            @ApiParam(value = "Id value from the user", required = true)
            @PathVariable UUID id,
            @ApiParam(value = "From - to dates for the holiday", required = true)
            @RequestBody Holiday holiday) {

        return userService.addHolidayToUser(id, holiday);
    }

    /**
     * @return 10 users by page, accepts 'page' as URL parameter as per Spring Pageable
     */
    @GetMapping("/all")
    @ApiOperation(
            value = "Find all user (pageable)",
            notes = "This end point have a pageable spring boot class",
            response = Page.class)

    public Page<User> getUsers(Pageable pageable) {
        return userService.getAllUsers(pageable);
    }
}
