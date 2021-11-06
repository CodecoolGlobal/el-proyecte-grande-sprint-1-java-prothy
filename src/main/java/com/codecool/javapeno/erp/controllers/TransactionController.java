package com.codecool.javapeno.erp.controllers;

import com.codecool.javapeno.erp.entities.Transaction;
import com.codecool.javapeno.erp.models.ErrorModel;
import com.codecool.javapeno.erp.models.UserTransactionModel;
import com.codecool.javapeno.erp.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    private final ErrorModel errorModel;

    @Autowired
    public TransactionController(TransactionService transactionService, ErrorModel errorModel) {
        this.transactionService = transactionService;
        this.errorModel = errorModel;
    }

    @GetMapping("/all")
    public Page<UserTransactionModel> getUserTransactions(@RequestParam(value = "userId", required = false) UUID userId, Pageable pageable) {

        return transactionService.getUserTransactionsById(userId, pageable);
    }

    @GetMapping("/top")
    public UserTransactionModel getUsersTopTransactions(@RequestParam(value = "userId", required = false) UUID userId) {

        return transactionService.getUsersTopTransactionsById(userId);
    }

    @GetMapping("/report_old")
    public List<Transaction> getReports_old(@RequestParam(value = "year", required = false) Integer year,
                                        @RequestParam(value = "month", required = false) Integer month) {

        return transactionService.getReports(year, month);
    }

    @GetMapping("/report")
    public Page<UserTransactionModel> getReports(@RequestParam(value = "userId", required = false) UUID userId,
                                                 @RequestParam(value = "dateFrom", required = false) String dateFrom,
                                                 @RequestParam(value = "dateTo", required = false) String dateTo){


        return transactionService.getAllTransactionsByUserBetweenDates(userId, dateFrom, dateTo);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ErrorModel notValidUUID() {
        errorModel.setErrorMessage("Not valid id");
        errorModel.setTime(LocalDateTime.now());
        errorModel.setStatus(HttpStatus.NOT_FOUND);
        return errorModel;
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ErrorModel userNotFound(Exception exception) {
        errorModel.setErrorMessage(exception.getMessage());
        errorModel.setTime(LocalDateTime.now());
        errorModel.setStatus(HttpStatus.NOT_FOUND);
        return errorModel;
    }
}
