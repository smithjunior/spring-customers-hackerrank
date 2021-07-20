package com.hackerrank.customers.model;

import java.io.Serializable;

public class Address implements Serializable {

    private Long id;
    private String street;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
