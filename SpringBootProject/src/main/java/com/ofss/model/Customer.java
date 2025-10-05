package com.ofss.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUST_ID")
	private int custId;
	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	private String firstName;
	@Column(name = "LAST_NAME", length = 100)
	private String lastName;
	@Column(name = "PHONE_NUMBER", length = 15)
	private long phoneNumber;
	@Column(name = "EMAIL_ID",unique = true, length = 150)
	private String emailId;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer( String firstName, String lastName, long phoneNumber, String emailId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
	}
	public int getCustId() {
		return custId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
