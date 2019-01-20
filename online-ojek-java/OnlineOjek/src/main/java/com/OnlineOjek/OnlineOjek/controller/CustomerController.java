package com.OnlineOjek.OnlineOjek.controller;

import com.OnlineOjek.OnlineOjek.model.Customer;
import com.OnlineOjek.OnlineOjek.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @CrossOrigin @PostMapping ("api/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
       return customerService.addCustomer(customer);
    }

    @CrossOrigin @GetMapping("api/customers")
    public List<Customer> getAllCustomer(){
        return  customerService.getAllCustomer();
    }

    @CrossOrigin @GetMapping("api/customers/status/eligible")
    public List<Customer> getEligibleCustomer(){
        return  customerService.getEligibleCustomer();
    }

    @CrossOrigin @GetMapping("api/customers/{cust_id}")
    public Customer getCustomer(@PathVariable("cust_id") Long cust_id) {
        return customerService.findCustomerById(cust_id);
    }
}