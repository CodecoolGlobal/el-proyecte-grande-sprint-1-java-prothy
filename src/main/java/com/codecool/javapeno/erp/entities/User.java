package com.codecool.javapeno.erp.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Column
    @Id
    @GeneratedValue
    @GenericGenerator(name="postgres-uuid", strategy = "uuid")
    private UUID id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column
    private Timestamp updatedDate;

    // personal info
    @Column
    @NotNull
    private String name;

    @Column
    private String phoneNumber;

    @Column
    @Email(message = "Email should be valid")
    @NotNull
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // work info
    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserPrivilege privilege;

    @Column
    private BigDecimal salary;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public UserStatus getStatus() {
        return status;
    }

    public UserPrivilege getPrivilege() {
        return privilege;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setPrivilege(UserPrivilege privilege) {
        this.privilege = privilege;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
