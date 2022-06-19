package com.example.springboot.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CustomerServiceTest {
    @Autowired
    private  CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jamila = new Customer(1L, "jamila", "hello", "jamila@gmail.com");
        Customer alice = new Customer(2L, "alice", "hello", "alice@gmail.com");
        customerRepository.saveAll(Arrays.asList(jamila, alice));
        List <Customer> customers =  underTest.getCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer jamila = new Customer(1L, "jamila", "hello", "jamila@gmail.com");
        customerRepository.save(jamila);
        Customer actual = underTest.getCustomer(1L);
        assertEquals(1L, actual.getId());
        assertEquals("jamila", actual.getName());
        assertEquals("hello", actual.getPassword());
        assertEquals("jamila@gmail.com", actual.getEmail());
    }
}