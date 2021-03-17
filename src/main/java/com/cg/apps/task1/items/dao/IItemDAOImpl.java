/*package com.cg.apps.task1.items.dao;

import com.cg.apps.task1.items.entities.*;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.apps.task1.items.exceptions.*;

@Repository
public class IItemDAOImpl implements IItemDAO {

	@Autowired
	private EntityManager em;

	@Transactional
	@Override
	public Item add(Item item) {
		em.persist(item);
		return item;

	}

	@Transactional
	@Override
	public Item update(Item item) {

		em.merge(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = em.find(Item.class, itemId);
		if(item == null) {
			throw new ItemNotFoundException("Item with id "+itemId+" not found");
		}
		return item;
	}

}*/
