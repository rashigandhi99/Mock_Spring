package com.cg.apps.task1.customerms.service;

import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.customerms.dao.*;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.entities.Account;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDAO dao;
	
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account(5000.0, now);
		entityManager.persist(account);
		Customer customer = new Customer(name, account);
		dao.add(customer);
		return customer;
	}

	@Override
	public Customer findById(Long customerId) {
		Customer customer = dao.findById(customerId);
		return customer;
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		Customer customer = dao.findById(customerId);
		Account account=customer.getAccount();
		account.setBalance(account.getBalance()  + amount);
		entityManager.persist(account);
		customer.getAccount().setBalance(amount);
		customer = dao.update(customer);
		return customer;
	}
	
	
	

}