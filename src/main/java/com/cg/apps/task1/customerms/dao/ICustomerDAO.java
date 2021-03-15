package com.cg.apps.task1.customerms.dao;

import com.cg.apps.task1.customerms.entities.*;
public interface ICustomerDAO {
	
	
	public Customer add(Customer customer);
    
	public Customer findById(long customerId);
    
	public Customer update(Customer customer);
	
	

}