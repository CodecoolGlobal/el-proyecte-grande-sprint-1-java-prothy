package com.codecool.javapeno.erp.models;

import com.codecool.javapeno.erp.entities.Transaction;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

public class UserTransactionModel {

    private UUID id;
    private Timestamp timestamp;
    private BigDecimal amount;

    public UserTransactionModel(Transaction transaction) {
        this.id = transaction.getId();
        this.timestamp = transaction.getTimestamp();
        this.amount = transaction.getAmount();
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
}
