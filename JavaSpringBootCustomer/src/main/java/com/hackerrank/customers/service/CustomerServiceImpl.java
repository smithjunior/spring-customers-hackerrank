package com.hackerrank.customers.service;

import com.hackerrank.customers.excpetion.BadResourceRequestException;
import com.hackerrank.customers.excpetion.NoSuchResourceFoundException;
import com.hackerrank.customers.model.Customer;
import com.hackerrank.customers.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteAllCustomers() {
        customerRepository.deleteAllInBatch();
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void createCustomer(Customer customer) {
        Customer existingCustomer = customerRepository.findOne(customer.getId());

        if (existingCustomer != null) {
            throw new BadResourceRequestException("Customer with same id exists.");
        }

        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findOne(id);

        if (customer == null) {
            throw new NoSuchResourceFoundException("No customer with given id found.");
        }

        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
