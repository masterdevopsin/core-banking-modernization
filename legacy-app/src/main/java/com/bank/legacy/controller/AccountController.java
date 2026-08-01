package com.bank.legacy.controller;


import com.bank.legacy.entity.Account;
import com.bank.legacy.service.AccountService;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;


@RestController
@RequestMapping("/api/accounts")
public class AccountController {


    private final AccountService service;


    public AccountController(AccountService service){

        this.service = service;

    }



    @PostMapping
    public Account createAccount(
            @RequestBody Map<String,String> request){


        return service.createAccount(
                Long.valueOf(request.get("customerId")),
                request.get("accountType"),
                new BigDecimal(request.get("initialDeposit"))
        );

    }




    @GetMapping("/{accountNumber}")
    public Account getAccount(
            @PathVariable String accountNumber){

        return service.getAccount(accountNumber);

    }




    @PostMapping("/deposit")
    public Account deposit(
            @RequestBody Map<String,String> request){


        return service.deposit(
                request.get("accountNumber"),
                new BigDecimal(request.get("amount"))
        );

    }




    @PostMapping("/withdraw")
    public Account withdraw(
            @RequestBody Map<String,String> request){


        return service.withdraw(
                request.get("accountNumber"),
                new BigDecimal(request.get("amount"))
        );

    }

}