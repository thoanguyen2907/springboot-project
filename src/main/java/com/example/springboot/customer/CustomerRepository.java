package com.example.springboot.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.List;

public interface CustomerRepository extends JpaRepository <Customer, Long>{


}
