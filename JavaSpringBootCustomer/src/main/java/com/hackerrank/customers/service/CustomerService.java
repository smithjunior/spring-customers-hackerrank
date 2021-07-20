package com.hackerrank.customers.service;

import com.hackerrank.customers.model.Customer;

import java.util.List;

public interface CustomerService {
    void deleteAllCustomers();

    void deleteCustomerById(Long id);

    void createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();
}
