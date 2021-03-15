package com.cg.apps.task1.customerms.controllers;

import java.util.Set;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.apps.task1.customerms.dto.*;
import com.cg.apps.task1.customerms.entities.*;
import com.cg.apps.task1.customerms.service.*;
import com.cg.apps.task1.customerms.util.*;
import com.cg.apps.task1.items.entities.*;


@RequestMapping("/customers")
@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil util;
	
	@GetMapping(value = "/findById/{id}")
	public CustomerDetails getDetailsById(@PathVariable("id") Long customerId) {
		Customer customer = service.findById(customerId);
		CustomerDetails details = util.toDetails(customer);
		return details;
	}
	
	 @PutMapping(value = "/addAmount")
	    public CustomerDetails addAmount(@RequestBody AddAmountRequest addAmountRequest)
	    {
	        Customer customer = service.addAmount(addAmountRequest.getId(),addAmountRequest.getAmount());
	        return util.toDetails(customer);
	    }
	 
	/* @PutMapping(value = "/add")
	 public CustomerDetails addCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
		 String Name=CreateCustomerRequest.getName();
		 Customer customer= service.createCustomer(Name);
		 return util.toDetails(customer);
	 }
	 */
	 
	 @GetMapping(value = "/getItems/{id}")
		public List<ItemBoughtByCustomer> getItemDetailsById(@PathVariable("id") Long customerId){
			Set<Item> setItem = service.itemsBoughtByCustomer(customerId);
			List<ItemBoughtByCustomer> itemList = util.toItemDetails(setItem);
			return itemList;
		}

	

}











