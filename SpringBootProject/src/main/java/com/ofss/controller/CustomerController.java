package com.ofss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.Customer;
import com.ofss.service.CustomerService;

@RestController
@RequestMapping("/api/v1/admin")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> listAllCustomers() {
		return customerService.listCustomers();
	}
	@GetMapping("/customers/id/{id}")
	public ResponseEntity<Object> getOneCustomers(@PathVariable("id") int customerId) {
		return customerService.getOneCustomer(customerId);
	}
	@PostMapping("/customers")
	public ResponseEntity<Object> addCustomers(@RequestBody Customer body) {
		return customerService.addCustomer(body);
	}
	@DeleteMapping("/customers/id/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int customerId){
		return customerService.deleteCustomer(customerId);
	}
	@PutMapping("/customers/id/{id}")
	public ResponseEntity<String> updateCustomerAllDetails(@PathVariable("id") int customerId,@RequestBody Customer customer){
		return customerService.updateAllCustomerDetails(customerId,customer);
	}
	@PatchMapping("/customers/id/{id}")
	public ResponseEntity<String> updateCustomerDetails(@PathVariable("id") int customerId,@RequestBody Customer customer){
		return customerService.updateCustomerDetails(customerId,customer);
	}
}
