package com.telecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.exception.ContactNotFoundException;
import com.telecom.exception.CustomerNotFoundException;
import com.telecom.model.ContactInformation;
import com.telecom.repository.ContactManagementRepo;

@Service
public class ContactServiceImpl implements ContactService{
	
	private static final Logger logger = LogManager.getLogger(ContactServiceImpl.class);

	@Autowired
	ContactManagementRepo contactManagementRepo;
	
	/**
	 * This method will return the contacts for all the customers.
	 */
	public List<ContactInformation> getAllContacts(){
		logger.info("Going to fetch contacts of all the customer.");
		List<ContactInformation> phoneList = new ArrayList<ContactInformation>();
		try {
			Set<String> ids = ContactManagementRepo.getContacts().keySet();
			for(String id : ids){
				phoneList.add(ContactManagementRepo.getContacts().get(id));
			}
			logger.info("Contacts successfully fetched.");
		}catch(Exception e) {
			logger.error("An error occurred while fetching the contacts info.");
		}
		return phoneList;
		
	}
	
	/**
	 * This method will return the contacts for a specific customer.
	 */
	public List<ContactInformation> getContactsByCustomerId(String customerId) throws CustomerNotFoundException{
		List<ContactInformation> phoneList = new ArrayList<ContactInformation>();
		if (null != customerId) {
			try {
				logger.info("Going to fetch contacts for the customer with Id : " + customerId);

				List<String> phoneNumberIds = ContactManagementRepo.getCustomers().get(customerId).getPhoneNumbers();
				for (String id : phoneNumberIds) {
					phoneList.add(ContactManagementRepo.getContacts().get(id));
				}
			} catch (Exception e) {
				logger.error("An error occurred while fetching the contacts info.");
				throw new CustomerNotFoundException(customerId);
			}
		} else {
			logger.info("Contact Id is not present.");
		}
		return phoneList;
	}
	
	/**
	 * This method will activate a given number based on the contact Id.
	 */
	public void activateNumber(String contactId) throws ContactNotFoundException{
		logger.info("Going to activate the number");
		try {
			ContactManagementRepo.getContacts().get(contactId).setActive(true);
			logger.info("Contacts successfully updated.");
		}catch(Exception e) {
			logger.error("An error occurred while updating the contacts info.");
			throw new ContactNotFoundException(contactId);
		}
		
	}
	
}
