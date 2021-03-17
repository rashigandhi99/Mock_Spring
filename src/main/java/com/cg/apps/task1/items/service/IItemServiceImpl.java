package com.cg.apps.task1.items.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;
import java.util.*;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.items.dao.*;
import com.cg.apps.task1.items.exceptions.*;

import com.cg.apps.task1.customerms.dao.*;
import com.cg.apps.task1.customerms.entities.Customer;
import com.cg.apps.task1.customerms.exceptions.*;
import com.cg.apps.task1.items.entities.Item;

@Service
public class IItemServiceImpl implements IItemService {

	/*@Autowired
	IItemDAO itemDao;
	
	@Autowired
	ICustomerDAO dao;*/
	
	@Autowired 
	IItemRepository itemRepository;
	
	@Autowired
	ICustomerRepository custRepository;

	@Autowired
	EntityManager em;
	
	
	public String generateItemId() {
		Random random = new Random();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			int generatedDigit = random.nextInt(9);
			builder.append(generatedDigit);
		}
		String itemId = builder.toString();
		return itemId;
	}

	@Transactional
	@Override
	public Item create(Double price, String description) {

		/*validatePrice(price);
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item( price, description);
		item.setId(itemId);
		item.setAddedDate(now);
		itemDao.add(item);
		return item;*/
		
		validatePrice(price);
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item( price, description);
		item.setId(itemId);
		item.setAddedDate(now);
	    itemRepository.save(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		/*Item item = itemDao.findById(itemId);
		return item;*/
		
		Optional<Item> optional = itemRepository.findById(itemId);
		if(!optional.isPresent()) {
			throw new ItemNotFoundException("Cannot find item with id "+itemId);
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {

		/*Customer customer = dao.findById(customerId);
		Item item = itemDao.findById(itemId);
		item.setBoughtBy(customer);
		Item updatedItem = itemDao.update(item);
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		dao.update(customer);
		return updatedItem;*/
		
		Optional<Customer> custOptional = custRepository.findById(customerId);
		if(!custOptional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+ customerId+" not found");
		}
		Customer customer = custOptional.get();
		
		Optional<Item> itemOptional = itemRepository.findById(itemId);
		if(!itemOptional.isPresent()) {
			throw new ItemNotFoundException("Cannot find item with id "+itemId);
		}
		Item item = itemOptional.get();
		
		item.setBoughtBy(customer);
		item = itemRepository.save(item);
		
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customer = custRepository.save(customer);
		
		return item;

	}
	
	public void validatePrice(double price) {
		if(price < 0) {
			throw new InvalidPriceException("Price cannot be less than 0");
		}
	}

}
