package com.telecom.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.model.ContactInformation;
import com.telecom.service.ContactService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerManagmentController {
	
	private static final Logger logger = LogManager.getLogger(CustomerManagmentController.class);

	@Autowired
	ContactService contactService;
	
    @RequestMapping(value = "/contacts/getAll")
    public List<ContactInformation> getAllContacts() {
    	logger.info("Going to fetch all the contacts.");
    	return contactService.getAllContacts();
    }
    
    
    @RequestMapping(value = "/contacts/{customerId}", method = RequestMethod.GET )
    public List<ContactInformation> getContactsByCustomerId(@PathVariable(value = "customerId") String customerId) {
    	logger.info("Going to fetch the contacts for a customer with Id : " + customerId);
    	List<ContactInformation> contactInfo = contactService.getContactsByCustomerId(customerId);
    	if(null != contactInfo && contactInfo.size() > 0) {
    		logger.debug("Successfully fetched the contact information for the customer");
    	}else {
    		logger.debug("Contact information could not be fetched.");
    	}
    	return contactInfo;
    }
    
    
    @RequestMapping(value = "/contacts/update/{contactId}", method = RequestMethod.PUT )
    public ResponseEntity<Object> activateNumber(@PathVariable(value = "contactId") String contactId) {
		try{
			logger.info("Going to activate the number with contact Id : " + contactId);
    		contactService.activateNumber(contactId);
    		logger.info("Successfully activated the contact number.");
    		return new ResponseEntity<>("Successfully activated the contact number.", HttpStatus.OK);
    	}
    	catch(Exception e) {
    		logger.info("Unable to activate contact number.");
    		return new ResponseEntity<>("Unable to activate contact number.", HttpStatus.NOT_MODIFIED);
    	}
    	
    }	
    
    
}