package com.example.springboot.customer;

import com.example.springboot.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RequestMapping(path = "api/v2/customers")
@RestController

public class CustomerControllerV2 {
    private final CustomerService customerService;
    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(value = "all")
    List<Customer> getCustomers() {
        return Collections.singletonList(
                new Customer(0L, "v2", "v2123", "thoa@gmail.com")
        );
    }
    @GetMapping(path = "{customerId}")
    Customer getCustomer(@PathVariable("customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping(path = "{customerId}/exception")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
        throw new ApiRequestException(
                "ApiRequestException for customer " + id
        );
    }

    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer) {
        System.out.println("POST REQUEST ....");
        System.out.println(customer);
    }
    @PutMapping
    void updateCustomer(@RequestBody Customer customer) {
        System.out.println("UPDATE REQUEST ....");
        System.out.println(customer);
    }
    @DeleteMapping (path = "{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }
}
