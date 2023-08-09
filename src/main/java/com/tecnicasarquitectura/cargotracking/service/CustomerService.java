package com.tecnicasarquitectura.cargotracking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnicasarquitectura.cargotracking.model.Customer;
import com.tecnicasarquitectura.cargotracking.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> getCustomers() {
		return customerRepository.findAll();	
	}
	
	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	public Customer updateCustomer(Long id, Customer customer) {

		return customerRepository.findById(id)
			      .map(c -> {
			    	  c.setName(customer.getName());
			    	  c.setPhone(customer.getPhone());
			    	  return customerRepository.save(c);
			      })
			      .orElseGet(() -> {
			        return customerRepository.save(customer);
			      });
	}

}
