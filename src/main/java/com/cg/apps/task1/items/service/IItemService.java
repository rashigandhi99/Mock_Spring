package com.cg.apps.task1.items.service;

import com.cg.apps.task1.items.entities.*;

public interface IItemService {

	Item create(Double price, String description);

	Item findByID(String itemID);

	Item buyItem(String itemID, Long customerID);

}
