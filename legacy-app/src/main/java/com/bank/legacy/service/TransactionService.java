package com.bank.legacy.service;

import com.bank.legacy.dto.TransferRequest;
import com.bank.legacy.entity.Account;
import com.bank.legacy.entity.Transaction;
import com.bank.legacy.repository.AccountRepository;
import com.bank.legacy.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository,
                              TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction transfer(TransferRequest request) {

        Account from = accountRepository
                .findByAccountNumber(request.getFromAccount())
                .orElseThrow(() -> new RuntimeException("Sender account not found"));

        Account to = accountRepository
                .findByAccountNumber(request.getToAccount())
                .orElseThrow(() -> new RuntimeException("Receiver account not found"));

        if (from.getBalance().compareTo(request.getAmount()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }

        // Debit sender account
        from.setBalance(from.getBalance().subtract(request.getAmount()));

        // Credit receiver account
        to.setBalance(to.getBalance().add(request.getAmount()));

        accountRepository.save(from);
        accountRepository.save(to);

        // Record transaction
        Transaction transaction = new Transaction();
        transaction.setTransactionReference(UUID.randomUUID().toString());
        transaction.setFromAccount(from.getAccountNumber());
        transaction.setToAccount(to.getAccountNumber());
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType("TRANSFER");
        transaction.setStatus("SUCCESS");

        // createdDate is automatically populated by @PrePersist
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}