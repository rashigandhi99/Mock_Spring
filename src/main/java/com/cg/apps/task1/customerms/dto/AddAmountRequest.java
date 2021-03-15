package com.cg.apps.task1.customerms.dto;

public class AddAmountRequest {
	private Long id;
	private double amount;

	public AddAmountRequest(Long id, double amount) {
		super();
		this.id = id;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}