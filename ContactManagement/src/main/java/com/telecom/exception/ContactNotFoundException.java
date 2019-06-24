package com.telecom.exception;

public class ContactNotFoundException extends RuntimeException {
	
	public ContactNotFoundException(String errorDetails) {
	    super("Contact couldn't be found for Customer : " + errorDetails);
	  }
}
