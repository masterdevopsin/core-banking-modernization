package com.bank.legacy.service;


import com.bank.legacy.entity.Customer;
import com.bank.legacy.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {


    private final CustomerRepository repository;


    public CustomerService(CustomerRepository repository){

        this.repository=repository;

    }


    public Customer create(Customer customer){

        return repository.save(customer);

    }


    public List<Customer> getAll(){

        return repository.findAll();

    }


    public Customer getById(Long id){

        return repository.findById(id)
                .orElseThrow(
                        ()->new RuntimeException("Customer not found"));

    }


    public void delete(Long id){

        repository.deleteById(id);

    }

}