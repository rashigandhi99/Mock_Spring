package com.cg.apps.task1.customerms.dto;

public class CustomerDetails {
	
	private Long id;
	private String name;
	private Long accountId;
	private double balance;
	
	public CustomerDetails() {
		
	}
	
	public CustomerDetails(Long id, String name, Long accountId, double balance) {
		this.id = id;
		this.name = name;
		this.accountId = accountId;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	

}