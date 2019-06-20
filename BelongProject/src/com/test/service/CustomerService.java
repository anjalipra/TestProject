package com.test.service;

import java.util.List;

import javax.ws.rs.PathParam;

import com.test.model.Customer;
import com.test.model.Phone;
import com.test.model.Response;

public interface CustomerService {

	/**
	 * This method fills up static sample customer data.
	 * @return
	 */
	public Response addCustomer();
	
	/**
	 * This method returns all the phone numbers for all the customer.
	 * @return
	 */
	public List<Phone> getAllPhoneNumbers();
	
	/**
	 * This method returns all the phone numbers for a specific customer.
	 * @param id
	 * @return
	 */
	public List<Phone> getAllPhoneNumbersOfCustomer(int id);

	/**
	 * This method activates the phone number mentioned.
	 * @param phone
	 * @return
	 */
	public Response activatePhoneNumber(String phone);
}
