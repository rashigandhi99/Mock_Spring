package com.cg.apps.task1.items.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.task1.items.dto.*;
import com.cg.apps.task1.items.entities.*;
import com.cg.apps.task1.items.service.*;
import com.cg.apps.task1.items.util.*;

@RequestMapping("/items")
@RestController
public class ItemRestController {
	
	@Autowired
	IItemService itemService;
	
	@Autowired
	ItemUtil util;
	
	@PutMapping("/buyItem")
	public ItemDetails buyItem(@RequestBody BuyItemRequest requestBody) {
		Item item = itemService.buyItem(requestBody.getItemId(), requestBody.getCustomerId());
		ItemDetails details = util.toDetails(item);
		return details;
	}
	
	
	@GetMapping(value = "/findById/{id}")
	public ItemDetails getItemById(@PathVariable("id") String itemId) {
		Item item = itemService.findById(itemId);
		ItemDetails details = util.toDetails(item);
		return details;
	}
		
	
}