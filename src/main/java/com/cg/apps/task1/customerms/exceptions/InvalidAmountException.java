package com.cg.apps.task1.customerms.exceptions;

public class InvalidAmountException extends RuntimeException {
	public InvalidAmountException(String msg) {
		super(msg);
	}
}