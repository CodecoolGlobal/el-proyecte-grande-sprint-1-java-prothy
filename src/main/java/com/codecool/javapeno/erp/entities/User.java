package com.codecool.javapeno.erp.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@ApiModel(description = "Details about the user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @ApiModelProperty(notes = "The unique id of the user")
    @Id
    @GeneratedValue
    @GenericGenerator(name = "postgres-uuid", strategy = "uuid")
    private UUID id;

    @ApiModelProperty(notes = "The day when created the user")
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Timestamp createdDate;

    @ApiModelProperty(notes = "The last day when modify some user data")
    @UpdateTimestamp
    private Timestamp updatedDate;

    // personal info
    @ApiModelProperty(notes = "The person's name")
    @NotNull
    private String name;

    @ApiModelProperty(notes = "The person's phone number")
    private String phoneNumber;

    @ApiModelProperty(notes = "The person's email address")
    @Email(message = "Email should be valid")
    @NotNull
    private String email;

    @ApiModelProperty(notes = "The person's address")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    // work info
    @ApiModelProperty(notes = "The user activity status")
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @ApiModelProperty(notes = "The user privilege")
    @NotNull
    @Enumerated(EnumType.STRING)
    private UserPrivilege privilege;

    @ApiModelProperty(notes = "The user monthly salary")
    private BigDecimal salary;

}
