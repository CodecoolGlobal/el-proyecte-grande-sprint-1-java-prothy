package com.codecool.javapeno.erp.models;

import com.codecool.javapeno.erp.entities.Address;
import com.codecool.javapeno.erp.entities.UserPrivilege;
import com.codecool.javapeno.erp.entities.UserStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class UserModel {
    private UUID id;
    private LocalDate updatedDate;

    // personal info
    private String name;
    private String phoneNumber;
    private String email;
    private Address address;

    // work info
    private UserStatus status;
    private UserPrivilege privilege;
    private BigDecimal salary;

    public UUID getId() {
        return id;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserPrivilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(UserPrivilege privilege) {
        this.privilege = privilege;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
