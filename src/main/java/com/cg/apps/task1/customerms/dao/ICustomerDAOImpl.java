package com.cg.apps.task1.customerms.dao;

import com.cg.apps.task1.customerms.entities.*;


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
		em.persist(customer);
		return customer;
	}
	@Override
	public Customer findById(long customerId) {
		Customer customer=em.find(Customer.class,customerId);
		return customer;
	}
	
	@Transactional
	@Override
	public Customer update(Customer customer) {
		em.merge(customer);
		return customer;
	}
	
}