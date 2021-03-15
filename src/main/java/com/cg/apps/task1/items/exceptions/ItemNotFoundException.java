package com.cg.apps.task1.items.exceptions;

public class ItemNotFoundException extends RuntimeException {
	public ItemNotFoundException(String msg) {
		super(msg);
	}
}