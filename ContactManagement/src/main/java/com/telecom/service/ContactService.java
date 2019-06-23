package com.telecom.service;

import java.util.List;

import com.telecom.model.ContactInformation;

public interface ContactService {
	
	public abstract List<ContactInformation> getAllContacts();
	
	public abstract List<ContactInformation> getContactsByCustomerId(String customerId);
	
	public abstract void activateNumber(String contactId);
}