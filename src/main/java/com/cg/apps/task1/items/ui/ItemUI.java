package com.cg.apps.task1.items.ui;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.apps.task1.items.entities.*;
import com.cg.apps.task1.items.service.*;
import com.cg.apps.task1.customerms.entities.Account;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.service.*;

@Component
public class ItemUI {

	@Autowired
	private IItemService service;
	@Autowired
	private ICustomerService custService;
	
	
	public void start() {
		
		
	}
	

	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer Id " + customer.getId() + "\nCustomer Name " + customer.getName()
				+ " \n Customer Account Id  " + account.getAccountID() + "\n Account Balance " + account.getBalance()
				+ " \n Time Of Creation" + account.getCreated());

	}

	void displayItemDetails(Item item) {

		System.out.println("Item id of customer is " + item.getId() + "\n Item description is " + item.getDescription()
				+ "\n Price of item bought by customer is " + item.getPrice() + "\nItem bought on "
				+ item.getAddedDate());

	}
}