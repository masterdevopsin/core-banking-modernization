package com.bank.legacy.repository;


import com.bank.legacy.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository
        extends JpaRepository<Customer,Long> {


}