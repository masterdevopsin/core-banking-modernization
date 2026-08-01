package com.bank.legacy.controller;

import com.bank.legacy.entity.Customer;
import com.bank.legacy.service.CustomerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // Create Customer
    @PostMapping
    public Customer create(@RequestBody Customer customer) {

        return service.create(customer);

    }

    // Get All Customers
    @GetMapping
    public List<Customer> getAll() {

        return service.getAll();

    }

    // Get Customer By ID
    @GetMapping("/{id}")
    public Customer getById(@PathVariable Long id) {

        return service.getById(id);

    }

    // Delete Customer
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "Customer deleted successfully";

    }

}