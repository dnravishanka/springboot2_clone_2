package com.example.springboot2.service.impl;

import com.example.springboot2.dto.CustomerDto;
import com.example.springboot2.entity.Customer;
import com.example.springboot2.repository.CustomerRepository;
import com.example.springboot2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void saveCustomer(CustomerDto dto) {
        Customer customer = new Customer(dto.getId(),dto.getName(), dto.getAddress());
        customerRepository.save(customer);
    }
}
