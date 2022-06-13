package com.example.springboot.customer;

import com.example.springboot.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service

public class CustomerService {
    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
     List<Customer> getCustomer() {
        return   customerRepo.getCustomers() ;
    }

    Customer getCustomer(Long id) {
        return getCustomer()
                .stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(()-> new NotFoundException("customer with ID " + id +  " not found"));
    }
}
