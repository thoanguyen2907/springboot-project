package com.example.springboot.customer;

import java.util.Collections;
import java.util.List;

public class CustomerRepository implements CustomerRepo {

    @Override
    public List<Customer> getCustomers() {
        //todo  connect to real db
        return Collections.singletonList (
                new Customer(1L, "Implement real db", "1233", "thoa@gmail.com")
        );
    }
}
