package com.ofss.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRANSACTION_ID")
	private int transactionId;
	@Column(name="CUSTOMER_ID")
	private int customerId;
	@Column(name="DESTINATION_ACCOUNT_ID")
	private int destinationAccountId;
	@Column(name="TRANSACTION_DATE")
	private LocalDate transactionDate;
	@Column(name="TRANSACTION_TYPE")
	private String transactionType;
	@Column(name="TRANSACTION_AMOUNT")
	private double trasactionAmount;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction( int customerId,  int destinationAccountId, LocalDate transactionDate,
			String transactionType, double trasactionAmount) {
		super();
		this.customerId = customerId;
		this.destinationAccountId = destinationAccountId;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.trasactionAmount = trasactionAmount;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getDestinationAccountId() {
		return destinationAccountId;
	}
	public void setDestinationAccountId(int destinationAccountId) {
		this.destinationAccountId = destinationAccountId;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTrasactionAmount() {
		return trasactionAmount;
	}
	public void setTrasactionAmount(double trasactionAmount) {
		this.trasactionAmount = trasactionAmount;
	}
	
}
