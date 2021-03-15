package com.cg.apps.task1.customerms.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}