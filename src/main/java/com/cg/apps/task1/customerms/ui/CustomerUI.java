package com.cg.apps.task1.customerms.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.apps.task1.customerms.entities.*;
import com.cg.apps.task1.customerms.service.*;

@Component
public class CustomerUI {
	
	@Autowired
	ICustomerService service;
	
	public void start() {
		
		Customer rashi = service.createCustomer("Rashi");
		display(rashi);
		
		Customer jhalak = service.createCustomer("Jhalak");
		display(jhalak);
		
		Customer findCustomer = service.findById(4L);
		display(findCustomer);
		
		Long rashiId = rashi.getId();
		Customer rashiAmount = service.addAmount(rashiId, 202.0);
		display(rashiAmount);
		
	}
	
	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer Id "+customer.getId()+"\nCustomer Name "+customer.getName()+" \n Customem Account Id  "+account.getAccountID()+"\n Account Balance "
		+account.getBalance()+" \n Time Of Creation"+account.getCreated());
	}

}