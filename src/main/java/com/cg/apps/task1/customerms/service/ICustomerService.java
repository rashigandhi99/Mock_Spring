package com.cg.apps.task1.customerms.service;

import com.cg.apps.task1.customerms.entities.*;
import com.cg.apps.task1.items.entities.*;
import java.util.Set;


public interface ICustomerService {
	
    Customer findById(Long customerId);
	
	Customer createCustomer(String name);	
	
	Customer addAmount(Long customerId, double amount);
	
	Set<Item> itemsBoughtByCustomer(Long customerID);



}
