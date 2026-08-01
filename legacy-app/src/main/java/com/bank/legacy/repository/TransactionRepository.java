package com.bank.legacy.repository;

import com.bank.legacy.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {

    Transaction findByTransactionReference(String reference);

    List<Transaction> findByFromAccountOrToAccount(
            String from,
            String to
    );
}