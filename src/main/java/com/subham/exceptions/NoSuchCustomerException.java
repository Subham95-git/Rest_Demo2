package com.subham.exceptions;

public class NoSuchCustomerException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchCustomerException() {
		super();
	}

	public NoSuchCustomerException(String ex) {
		super(ex);
	}
	
	
}
