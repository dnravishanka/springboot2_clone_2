package com.example.springboot2.controller;

import com.example.springboot2.dto.CustomerDto;
import com.example.springboot2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @GetMapping
    public void customerMethod(@RequestBody CustomerDto dto) {
        customerService.saveCustomer(dto);
    }
}
