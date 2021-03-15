package com.cg.apps.task1.customerms.util;

import org.springframework.stereotype.Component;
import com.cg.apps.task1.items.entities.*;
import com.cg.apps.task1.customerms.dto.*;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.entities.Account;
import java.util.*;

@Component
public class CustomerUtil {
	
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName()
		, customer.getAccount().getAccountID(), customer.getAccount().getBalance());
		return customerDetails;
	}
	
	public List<ItemBoughtByCustomer> toItemDetails(Set<Item> itemSet) {
		List<ItemBoughtByCustomer> itemList = new ArrayList<>();
		for(Item item:itemSet) {
			ItemBoughtByCustomer itemDetails = new ItemBoughtByCustomer(item.getId(), item.getDescription());
			itemList.add(itemDetails);
		}
		return itemList;
	}
}