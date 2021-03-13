package com.cg.apps.task1.items.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;


@Entity
public class Item {
	
	String id;
	
	Double price;
	
	String description;
	
	LocalDateTime addedDate;
	
	
	

	public Item(Double price, String description, LocalDateTime addedDate) {
		this.price = price;
		this.description = description;
		this.addedDate = addedDate;
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
