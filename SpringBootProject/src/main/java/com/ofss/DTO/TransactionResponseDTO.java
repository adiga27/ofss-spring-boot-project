package com.ofss.DTO;

import com.ofss.model.Transaction;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionResponseDTO {
	private double fromAccountBalance;
	private double toAccountBalance;
	private double transferAmount;
	private Transaction transaction;
	private double totalFromAccountBalance;
	private double totalToAccountBalance;
	public TransactionResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResponseDTO(double fromAccountBalance, double toAccountBalance, double transferAmount,
			Transaction transaction, double totalFromAccountBalance, double totalToAccountBalance) {
		super();
		this.fromAccountBalance = fromAccountBalance;
		this.toAccountBalance = toAccountBalance;
		this.transferAmount = transferAmount;
		this.transaction = transaction;
		this.totalFromAccountBalance = totalFromAccountBalance;
		this.totalToAccountBalance = totalToAccountBalance;
	}
	public double getFromAccountBalance() {
		return fromAccountBalance;
	}
	public void setFromAccountBalance(double fromAccountBalance) {
		this.fromAccountBalance = fromAccountBalance;
	}
	public double getToAccountBalance() {
		return toAccountBalance;
	}
	public void setToAccountBalance(double toAccountBalance) {
		this.toAccountBalance = toAccountBalance;
	}
	public double getTransferAmount() {
		return transferAmount;
	}
	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	public double getTotalFromAccountBalance() {
		return totalFromAccountBalance;
	}
	public void setTotalFromAccountBalance(double totalFromAccountBalance) {
		this.totalFromAccountBalance = totalFromAccountBalance;
	}
	public double getTotalToAccountBalance() {
		return totalToAccountBalance;
	}
	public void setTotalToAccountBalance(double totalToAccountBalance) {
		this.totalToAccountBalance = totalToAccountBalance;
	}
	
	
}
