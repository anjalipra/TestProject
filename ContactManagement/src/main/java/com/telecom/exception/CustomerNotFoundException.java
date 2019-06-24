package com.telecom.exception;

public class CustomerNotFoundException extends RuntimeException {
	
	public CustomerNotFoundException(String errorDetails) {
	    super("Customer couldn't be found for Customer Id :" + errorDetails);
	  }
}
