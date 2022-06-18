package com.example.springboot.customer;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CustomerConfiguration {
    @Value("${app.useFakeCustomerRepo: false}")
    private Boolean useFakeCustomerRepo;

    @Value("${info.company.name}")
    private  String companyName;

   // @Autowired
    //private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Command Line runner !!!!");
            System.out.println(companyName);
           // System.out.println(environment.getProperty("info.app.version"));

        };
    }
    @Bean
    CustomerRepo customerRepo(){
        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
        return  new CustomerFakeRepository();
    }
}
