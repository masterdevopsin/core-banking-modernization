package com.bank.legacy.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "accounts")
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(unique = true, nullable = false)
    private String accountNumber;


    private String accountType;


    private BigDecimal balance;


    private Long customerId;


    private String status;


    private LocalDateTime createdDate;


    public Account() {

    }


    public Account(String accountNumber,
                   String accountType,
                   BigDecimal balance,
                   Long customerId) {

        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;
        this.status = "ACTIVE";
        this.createdDate = LocalDateTime.now();

    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getAccountType() {
        return accountType;
    }


    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }


    public BigDecimal getBalance() {
        return balance;
    }


    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public Long getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }


    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}