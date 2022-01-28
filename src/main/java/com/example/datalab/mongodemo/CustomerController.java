package com.example.datalab.mongodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable(value = "customerId") String customerId) {
        return customerRepository.findById(customerId).get();
    }

    @GetMapping("/customers/{lastName}")
    public List<Customer> getCustomersByLastname(@PathVariable(value = "lastname") String lastname) {
        return customerRepository.findByLastName(lastname);
    }

    @PostMapping("/customer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
