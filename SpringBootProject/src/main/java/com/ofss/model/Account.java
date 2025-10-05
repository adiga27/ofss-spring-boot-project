package com.ofss.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_NUMBER")
	private int accountNumber;
	@Column(name = "ACCOUNT_CREATION_DATE", nullable = false)
	private LocalDate accountCreationDate;// when you map this field to DB column, it should be of type DATE
	@Column(name = "ACCOUNT_TYPE", length = 20)
	private String accountType;
	@Column(name = "BALANCE")
	private double balance;
	@Column(name = "CUST_ID", nullable = false)
	private int custId; // property name, field name
	@Column(name = "BANK_ID", nullable = false)
	private int bankId; // property name, field name
	public Account( LocalDate accountCreationDate, String accountType, double balance,
			int custId, int bankId) {
		super();
		this.accountCreationDate = accountCreationDate;
		this.accountType = accountType;
		this.balance = balance;
		this.custId = custId;
		this.bankId = bankId;
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAccountNumber() {
		return accountNumber;
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
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	
}
