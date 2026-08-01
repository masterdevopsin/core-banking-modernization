package com.bank.legacy.controller;

import com.bank.legacy.dto.TransferRequest;
import com.bank.legacy.entity.Transaction;
import com.bank.legacy.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody TransferRequest request) {
        return transactionService.transfer(request);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
}