package com.hackerrank.customers.controller;

import com.hackerrank.customers.model.Customer;
import com.hackerrank.customers.service.CustomerService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCustomer(@RequestBody @Valid Customer customer) {
        customerService.createCustomer(customer);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllCustomers() {
        customerService.deleteAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
}
