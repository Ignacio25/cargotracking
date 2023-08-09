package com.tecnicasarquitectura.cargotracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnicasarquitectura.cargotracking.exception.ResourceNotFoundException;
import com.tecnicasarquitectura.cargotracking.model.Customer;
import com.tecnicasarquitectura.cargotracking.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllCustomers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/viewCustomer/{customerId}")
	public Customer getCustomerById(@PathVariable(value = "customerId") Long id) {
		
		return customerService.getCustomerById(id).
				orElseThrow(()-> new ResourceNotFoundException("No se encontro customer con id = " + id)); 
	}
	
	@PutMapping("/updateCustomer/{customerId}")
	public Customer updateCustomerId(@PathVariable(value = "customerId") Long id, @RequestBody Customer customer) {
		return customerService.updateCustomer(id, customer);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public void deleteCustomer(@PathVariable(value = "customerId") Long id) {
		customerService.deleteCustomer(id);
	}

}
