package com.cg.apps.task1.customerms.exceptions;

public class InvalidCustomerIdException extends RuntimeException{
	public InvalidCustomerIdException(String msg) {
		super(msg);
	}
}