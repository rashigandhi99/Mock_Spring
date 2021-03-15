package com.cg.apps.task1.items.service;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.apps.task1.items.dao.*;
import com.cg.apps.task1.items.entities.*;
@Service
public class IItemServiceImpl implements IItemService {

	@Autowired
	IItemDAO itemDao;

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

		
		Item item = new Item( price, description);
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		item.setId(itemId);
		item.setAddedDate(now);
		itemDao.add(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = itemDao.findById(itemId);
		return item;
	}

	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {

		return null;

	}

}
