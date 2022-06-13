package com.example.springboot.customer;

import java.util.Arrays;
import java.util.List;


public class CustomerFakeRepository  implements CustomerRepo {
   @Override
   public List<Customer> getCustomers() {
      return Arrays.asList(
              new Customer(1L, "James Bond", "123", "thoa@gmail.com"),
              new Customer(2L, "James Bond 2", "123", "thoa@gmail.com"),
              new Customer(3L, "James Bond 3", "123", "thoa@gmail.com")
      );
   }
}
