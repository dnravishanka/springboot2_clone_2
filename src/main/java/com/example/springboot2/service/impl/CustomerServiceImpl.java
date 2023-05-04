package com.example.springboot2.service.impl;

import com.example.springboot2.dto.CustomerDto;
import com.example.springboot2.entity.Customer;
import com.example.springboot2.repository.CustomerRepository;
import com.example.springboot2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void saveCustomer(CustomerDto dto) {
        Customer customer = new Customer(dto.getId(),dto.getName(), dto.getAddress(),dto.getSalary());
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerDto dto) {
        Customer customer = new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getSalary());
        customerRepository.save(customer);


    }

    @Override
    public void deleteCustomer(String id) {
    Optional<Customer> customer= customerRepository.findAllById(id);
    customerRepository.delete(customer.get());

    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> all = customerRepository.findAll();
        List<CustomerDto> dtoList=new ArrayList<>();
        for (Customer cus:all) {
            CustomerDto customerDto = new CustomerDto(cus.getId(),cus.getName(),cus.getAddress(),cus.getSalary());
            dtoList.add(new CustomerDto(cus.getId(),cus.getName(),cus.getAddress(),cus.getSalary()));
        }

       return dtoList;
    }

    @Override
    public CustomerDto searchCustomerByID(String id) {
        Optional<Customer> customerById = customerRepository.findAllById(id);
        Customer customer = customerById.get();
        CustomerDto customerDto = new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());

        return customerDto;
    }

    @Override
    public CustomerDto SearchCustomerByAddress(String address) {
        Optional<Customer> customerByAddress = customerRepository.findCustomerByAddress(address);
        Customer customer = customerByAddress.get();
        CustomerDto customerDto = new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());

        return customerDto;
    }

    @Override
    public CustomerDto SearchCustomerByName(String name) {
        Optional<Customer> customerByName = customerRepository.findCustomerByName(name);
        Customer customer = customerByName.get();
        CustomerDto customerDto = new CustomerDto(customer.getId(),customer.getName(),customer.getAddress(),customer.getSalary());

        return customerDto;
    }
}
