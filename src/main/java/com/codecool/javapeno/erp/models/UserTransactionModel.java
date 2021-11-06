package com.codecool.javapeno.erp.models;

import com.codecool.javapeno.erp.entities.Transaction;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class UserTransactionModel {

    private UUID id;
    private Timestamp timestamp;
    private BigDecimal amount;
    private String accountNumFrom;
    private String accountNumTo;

    public UserTransactionModel(Transaction transaction) {
        this.id = transaction.getId();
        this.timestamp = transaction.getTimestamp();
        this.amount = transaction.getAmount();
        this.accountNumFrom = transaction.getAccountNumFrom();
        this.accountNumTo = transaction.getAccountNumTo();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAccountNumFrom() {
        return accountNumFrom;
    }

    public void setAccountNumFrom(String accountNumFrom) {
        this.accountNumFrom = accountNumFrom;
    }

    public String getAccountNumTo() {
        return accountNumTo;
    }

    public void setAccountNumTo(String accountNumTo) {
        this.accountNumTo = accountNumTo;
    }
}
