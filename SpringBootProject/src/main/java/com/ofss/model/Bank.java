package com.ofss.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "BANK")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BANK_ID")
	private int bankId; 
	@Column(name = "BANK_NAME", nullable = false, length = 200)
	private String bankName;
	@Column(name = "BRANCH_NAME", length = 200)
	private String branchName;
	@Column(name = "IFSC_CODE", nullable = false, unique = true, length = 20)
	private String ifscCode;

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String bankName, String branchName, String ifscCode) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
		this.ifscCode = ifscCode;
	}

	public int getBankId() {
		return bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

}
