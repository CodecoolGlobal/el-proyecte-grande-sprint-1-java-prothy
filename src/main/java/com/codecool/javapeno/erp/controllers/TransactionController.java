package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.Transaction;
import com.codecool.javapeno.erp.models.UserTransactionModel;
import com.codecool.javapeno.erp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public List<UserTransactionModel> getUserTransactions(@RequestParam(value = "userId", required = false) UUID userId) {
        if (userId == null) return null;

        return transactionService.getUserTransactionsById(userId);
    }

    @GetMapping("/top")
    public UserTransactionModel getUsersTopTransactions(@RequestParam(value = "userId", required = false) UUID userId) {
        if (userId == null) return null;

        return transactionService.getUsersTopTransactionsById(userId);
    }

    @GetMapping("/report")
    public List<Transaction> getReports(@RequestParam(value = "year", required = false) Integer year,
                                        @RequestParam(value = "month", required = false) Integer month) {

        return transactionService.getReports(year, month);
    }
}
