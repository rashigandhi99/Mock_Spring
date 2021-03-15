package com.cg.apps.task1.items.dto;

public class ItemDetails {
	
	private String itemId;
	private double price;
	private String description;
	private Long customerId;
	private String customerName;
	
	public ItemDetails() {
		
	}
	
	public ItemDetails(String itemId, double price, String description, Long customerId, String customerName) {
		this.itemId = itemId;
		this.price = price;
		this.description = description;
		this.customerId = customerId;
		this.customerName = customerName;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
}