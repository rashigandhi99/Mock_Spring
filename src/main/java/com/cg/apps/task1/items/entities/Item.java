package com.cg.apps.task1.items.entities;

import java.time.LocalDateTime;
import javax.persistence.Id;
import javax.persistence.Entity;

import javax.persistence.ManyToOne;

import com.cg.apps.task1.customerms.entities.*;

@Entity
public class Item {
	@Id
	String id;

	Double price;

	String description;

	LocalDateTime addedDate;

	@ManyToOne
	Customer boughtBy;
	
	public Item() {}

	public Item(Double price, String description) {

		this.price = price;
		this.description = description;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}
	

	public Customer getBoughtBy() {
		return boughtBy;
	}

	public void setBoughtBy(Customer boughtBy) {
		this.boughtBy = boughtBy;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
