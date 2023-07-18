package com.Springboot.services;

import com.Springboot.entity.Customer;
import com.Springboot.repository.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepo repo;


    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public void addCustomer(Customer customer) {
        repo.save(customer);
    }

    public void deleteCustomer(Integer id) {
        repo.deleteById(id);
    }

    public void updateCustomer(Integer id, Customer customer) {
        Customer customer1 = repo.findById(id).orElseThrow(() -> new RuntimeException(" Customer Not Found"));
        customer1.setName(customer.getName());
        customer1.setAge(customer.getAge());
        customer1.setEmail(customer.getEmail());
    }
}
