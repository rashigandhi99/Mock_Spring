package com.cg.apps.task1.customerms.ui;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.apps.task1.customerms.entities.*;
import com.cg.apps.task1.customerms.service.*;
import com.cg.apps.task1.items.entities.*;
import com.cg.apps.task1.customerms.exceptions.*;
import com.cg.apps.task1.items.service.*;
@Component
public class CustomerUI {
	
	@Autowired
	private ICustomerService customerService;
	@Autowired
	private IItemService itemService;

	public void start() {
		try {
			Customer rashi = customerService.createCustomer("Rashi");
			Customer jhalak = customerService.createCustomer("Jhalak");
			Item addedItem = itemService.create(170.0, "Apple");
			Item addedItem1 = itemService.create(250.0, "Orange");
			Long cust1Id = rashi.getId();
			Long cust2Id = jhalak.getId();
			Item boughtItem = itemService.buyItem(addedItem.getId(), cust1Id);
			Item boughtItem1 = itemService.buyItem(addedItem1.getId(), cust2Id);
			System.out.println("Printing the items bought by " + rashi.getName());
			Customer cust1Fetched = customerService.findById(cust1Id);
			display(cust1Fetched);
			
			System.out.println("                                                                       ");
			System.out.println("Printing the items bought by " + jhalak.getName());
			Customer cust2Fetched = customerService.findById(cust1Id);
			display(cust2Fetched);
			
			
		} catch (InvalidCustomerIdException e) {
			System.out.println(e.getMessage());
		} catch (InvalidNameException e) {
			System.out.println(e.getMessage());
		} catch (InvalidAmountException e) {
			System.out.println(e.getMessage());
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		
	}
	
	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer Id "+customer.getId()+"\nCustomer Name "+customer.getName()+
				" \n Customer Account Id  "+account.getAccountID()+"\n Account Balance "
		+account.getBalance()+" \n Time Of Creation"+account.getCreated());
		
		Set<Item> itemsBought = customer.getBoughtItems();
		for (Item item : itemsBought) {
			displayItemDetails(item);
		}
	}
	
	
	void displayItemDetails(Item item) {
		
		System.out.println("Item id of customer is "+ item.getId()+"\n Item description is "+ item.getDescription()
		+"\n Price of item bought by customer is "+item.getPrice()+ "\nItem bought on " +item.getAddedDate());
		
	}
	

}