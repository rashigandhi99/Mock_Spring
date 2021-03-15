package com.cg.apps.task1.items.service;

import com.cg.apps.task1.items.entities.*;

public interface IItemService {

	Item create(Double price, String description);

	Item findById(String itemID);

	Item buyItem(String itemId, Long customerId);

}
