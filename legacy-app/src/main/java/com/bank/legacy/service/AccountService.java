package com.bank.legacy.service;


import com.bank.legacy.entity.Account;
import com.bank.legacy.repository.AccountRepository;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;


@Service
public class AccountService {


    private final AccountRepository repository;


    public AccountService(AccountRepository repository){

        this.repository = repository;

    }



    public Account createAccount(Long customerId,
                                 String accountType,
                                 BigDecimal initialDeposit){


        String accountNumber =
                "ACC" + UUID.randomUUID()
                        .toString()
                        .substring(0,8)
                        .toUpperCase();


        Account account =
                new Account(
                        accountNumber,
                        accountType,
                        initialDeposit,
                        customerId
                );


        return repository.save(account);

    }




    public Account getAccount(String accountNumber){

        return repository
                .findByAccountNumber(accountNumber)
                .orElseThrow(
                        () -> new RuntimeException("Account not found"));

    }




    public Account deposit(String accountNumber,
                           BigDecimal amount){


        Account account=getAccount(accountNumber);


        account.setBalance(
                account.getBalance()
                        .add(amount)
        );


        return repository.save(account);

    }




    public Account withdraw(String accountNumber,
                            BigDecimal amount){


        Account account=getAccount(accountNumber);


        if(account.getBalance()
                .compareTo(amount)<0){

            throw new RuntimeException(
                    "Insufficient balance");

        }


        account.setBalance(
                account.getBalance()
                        .subtract(amount)
        );


        return repository.save(account);

    }

}