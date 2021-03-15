package com.cg.apps.task1.customerms.dto;

public class ItemBoughtByCustomer {
	
	private String itemId;
	private String description;
	
	public ItemBoughtByCustomer(String itemId, String description) {
		this.itemId = itemId;
		this.description = description;
	}
	
	public String getItemId() {
		return itemId;
	}
	
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}