package com.cg.apps.task1.items.util;

import org.springframework.stereotype.Component;

import com.cg.apps.task1.customerms.dto.*;
import com.cg.apps.task1.items.entities.*;
import com.cg.apps.task1.items.dto.*;

@Component
public class ItemUtil {
	
	public ItemDetails toDetails(Item item) {
		ItemDetails details = new ItemDetails(item.getId(), item.getPrice(), item.getDescription()
				, item.getBoughtBy().getId(), item.getBoughtBy().getName());
		return details;
	}

}