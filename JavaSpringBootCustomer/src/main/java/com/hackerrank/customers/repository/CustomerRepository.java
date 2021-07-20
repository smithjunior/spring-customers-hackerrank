package com.hackerrank.customers.repository;

import com.hackerrank.customers.model.Customer;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customerRepository")
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    Long deleteById(Long id);
}
