/*package com.cg.apps.task1.customerms.dao;

import java.time.LocalDateTime;

import com.cg.apps.task1.customerms.entities.*;
import com.cg.apps.task1.customerms.exceptions.*;

import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ICustomerDAOImpl implements ICustomerDAO{
	
	@Autowired
	private EntityManager em;
	
	@Transactional
	@Override
	public Customer add(Customer customer) {
		LocalDateTime now = LocalDateTime.now();
		Account account = customer.getAccount();
		account.setCreated(now);
		em.persist(account);
		em.persist(customer);
		return customer;
	}
	@Override
	public Customer findById(long customerId) {
		Customer customer=em.find(Customer.class,customerId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer does not exist for ID: " + customerId);
		}
		return customer;
	}
	
	@Transactional
	@Override
	public Customer update(Customer customer) {
		em.merge(customer);
		return customer;
	}
	
}*/