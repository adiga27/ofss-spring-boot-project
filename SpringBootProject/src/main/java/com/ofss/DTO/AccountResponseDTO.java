package com.ofss.DTO;

import java.time.LocalDate;

import com.ofss.model.Bank;
import com.ofss.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponseDTO {
	private int accountNumber;
	private LocalDate accountCreationDate;
	private String accountType;
	private double balance;
	private Customer customer;
	private Bank bank;
	// constructors, getters, setters

	public AccountResponseDTO(int accountNumber, LocalDate accountCreationDate, String accountType, double balance,
			Customer customer, Bank bank) {
		this.accountNumber = accountNumber;
		this.accountCreationDate = accountCreationDate;
		this.accountType = accountType;
		this.balance = balance;
		this.customer = customer;
		this.bank = bank;
	}

	public AccountResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LocalDate getAccountCreationDate() {
		return accountCreationDate;
	}

	public void setAccountCreationDate(LocalDate accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
}