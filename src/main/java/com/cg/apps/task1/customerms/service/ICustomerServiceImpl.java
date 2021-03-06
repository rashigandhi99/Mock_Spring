package com.cg.apps.task1.customerms.service;

import java.time.LocalDateTime;

import java.util.Optional;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.customerms.dao.*;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.exceptions.*;
import com.cg.apps.task1.customerms.entities.Account;
import com.cg.apps.task1.items.entities.*;

import java.util.Set;
import java.util.HashSet;

@Service
public class ICustomerServiceImpl implements ICustomerService{
	
	/*@Autowired
	ICustomerDAO dao;*/
	
	@Autowired
	ICustomerRepository custRepository;
	
	@Autowired
	IAccountRepository accountRepository;
	
	
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		/*validateName(name);
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account(5000.0, now);
		entityManager.persist(account);
		Set<Item> set = new HashSet<>();
		Customer customer = new Customer(name, account,set);
		dao.add(customer);
		return customer;*/
		
		validateName(name);
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account(5000.0, now);
		accountRepository.save(account);
		Set<Item> set = new HashSet<>();
		Customer customer = new Customer(name, account,set);
		custRepository.save(customer);
		return customer;
		
	}

	@Override
	public Customer findById(Long customerId) {
		/*validateCustomerId(customerId);
		Customer customer = dao.findById(customerId);
		return customer;*/
		Optional<Customer> optional = custRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+customerId+" not found");
		}
		return optional.get();
		
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		/*validateCustomerId(customerId);
		Customer customer = dao.findById(customerId);
		Account account=customer.getAccount();
		account.setBalance(account.getBalance()  + amount);
		entityManager.persist(account);
		customer.getAccount().setBalance(amount);
		customer = dao.update(customer);
		return customer;*/
		
		validateCustomerId(customerId);
		Customer customer = findById(customerId);
		Account account=customer.getAccount();
		account.setBalance(account.getBalance()  + amount);
		accountRepository.save(account);
		customer.getAccount().setBalance(amount);
		customer =custRepository.save(customer);
		return customer;
	}
	
	@Transactional
	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId) {
		/*validateCustomerId(customerId);
		Customer customer = dao.findById(customerId);
		return customer.getBoughtItems();*/
		
		validateCustomerId(customerId);
		Optional<Customer> optional = custRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+customerId+" not found");
		}
		Customer customer = optional.get();
		Set<Item> itemSet = customer.getBoughtItems();
		return itemSet;

	}
	
	public void validateCustomerId(Long id) {
		if (id == null) {
			throw new InvalidCustomerIdException("The entered ID " + id + " is invalid");
		}
	}
	
	public void validateName(String name) {
		if (name == null || name.isEmpty() || name.trim().isEmpty()) {
			throw new InvalidNameException("Name cannot be null");
		}
	}
	

}