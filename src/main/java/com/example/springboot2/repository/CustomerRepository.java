package com.example.springboot2.repository;

import com.example.springboot2.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , String> {
}
