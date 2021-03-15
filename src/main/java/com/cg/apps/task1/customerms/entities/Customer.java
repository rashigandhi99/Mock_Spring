package com.cg.apps.task1.customerms.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;


import java.util.Set;

import com.cg.apps.task1.items.entities.*;


@Entity
public class Customer{

	@GeneratedValue
	@Id
	private long id;
	private String name;
		
	@OneToOne
    Account account;
	public Customer(){
		
	}	
	@OneToMany(fetch = FetchType.EAGER)
	Set<Item> boughtItems;
	
	
	public Customer(String name, Account account,Set<Item> boughtItems){
		this.name = name;
		this.account = account;
		this.boughtItems=boughtItems;
	}


	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}
	
	public Set<Item> getBoughtItems() {
		return boughtItems;
	}


	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}

	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", account=" + account + "]";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}