package com.ofss.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ofss.model.Customer;
import com.ofss.model.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public ResponseEntity<Object> addCustomer(Customer customer) {
		Customer newCustomer = customerRepository.save(customer);
		if (newCustomer.getCustId() != 0) {
			return ResponseEntity.ok("Customer added successfully!");
		}
		return ResponseEntity.ok("Customer is not added, add proper payload");
	}

	public List<Customer> listCustomers() {
		ArrayList<Customer> allCustomers = new ArrayList<>();
		customerRepository.findAll().forEach(customer -> allCustomers.add(customer));
		return allCustomers;
	}

	public ResponseEntity<Object> getOneCustomer(int customerId) {
		if (customerRepository.existsById(customerId)) {
			return ResponseEntity.ok(customerRepository.findById(customerId));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	}

	public ResponseEntity<String> deleteCustomer(int customerId) {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
	}

	public ResponseEntity<String> updateAllCustomerDetails(int customerId, Customer updateCustomerData) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customer.setFirstName(updateCustomerData.getFirstName());
			customer.setLastName(updateCustomerData.getLastName());
			customer.setPhoneNumber(updateCustomerData.getPhoneNumber());
			customer.setEmailId(updateCustomerData.getEmailId());

			customerRepository.save(customer);
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");

	}

	public ResponseEntity<String> updateCustomerDetails(int customerId, Customer updateCustomerData) {

		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			if (updateCustomerData.getFirstName() != null) {
				customer.setFirstName(updateCustomerData.getFirstName());
			}
			if (updateCustomerData.getLastName() != null) {
				customer.setLastName(updateCustomerData.getLastName());
			}
			if (updateCustomerData.getPhoneNumber() != 0) {
				customer.setPhoneNumber(updateCustomerData.getPhoneNumber());
			}
			if (updateCustomerData.getEmailId() != null) {
				customer.setEmailId(updateCustomerData.getEmailId());
			}

			customerRepository.save(customer);
			return ResponseEntity.status(HttpStatus.OK).body("Updated Successfully");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");

	}

}
