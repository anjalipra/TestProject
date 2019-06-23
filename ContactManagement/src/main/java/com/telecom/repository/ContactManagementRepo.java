package com.telecom.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.telecom.model.Customer;
import com.telecom.model.ContactInformation;

@Repository
public class ContactManagementRepo {

	private static Map<String, Customer> customers = new HashMap<String, Customer>();
	private static Map<String, ContactInformation> contacts = new HashMap<String, ContactInformation>();

	public static Map<String, Customer> getCustomers() {
		return customers;
	}

	public static void setCustomers(Map<String, Customer> customers) {
		ContactManagementRepo.customers = customers;
	}

	public static Map<String, ContactInformation> getContacts() {
		return contacts;
	}

	public static void setContacts(Map<String, ContactInformation> contacts) {
		ContactManagementRepo.contacts = contacts;
	}

	static {
		ContactInformation contact1 = new ContactInformation();
		contact1.setContactId("1");
		contact1.setCountryCode("+61");
		contact1.setPhoneNumber("123 456 678");
		contact1.setType("HOME");
		contact1.setActive(true);
		contact1.setCustomerId("1");
		contacts.put("1", contact1);
		
		ContactInformation contact2 = new ContactInformation();		
		contact2.setContactId("2");
		contact2.setCountryCode("+61");
		contact2.setPhoneNumber("4493 897 789");
		contact2.setType("OFFICE");
		contact2.setActive(true);
		contact2.setCustomerId("1");
		contacts.put("2", contact2);
		
		ContactInformation contact3 = new ContactInformation();
		contact3.setContactId("3");
		contact3.setCountryCode("+61");
		contact3.setPhoneNumber("998 776 432");
		contact3.setType("OFFICE");
		contact3.setActive(true);
		contact3.setCustomerId("2");
		contacts.put("3", contact3);
		
		ContactInformation contact4 = new ContactInformation();
		contact4.setContactId("4");
		contact4.setCountryCode("+61");
		contact4.setPhoneNumber("345 321 888");
		contact4.setType("HOME");
		contact4.setActive(true);
		contact4.setCustomerId("2");
		contacts.put("4", contact4);
		
		//First Customer Info
		Customer customer = new Customer();
		customer.setFirstName("Anjali");
		customer.setLastName("Prakash");
		customer.setCustomerId("1");
		List<String> firstPhoneList = new ArrayList<String>();
		firstPhoneList.add("1");
		firstPhoneList.add("2");
		customer.setPhoneNumbers(firstPhoneList);
		customers.put("1", customer);

		//Second Customer Info
		Customer customer1 = new Customer();
		customer1.setFirstName("Andrew");
		customer1.setLastName("Thomas");
		customer1.setCustomerId("2");
		List<String> secondPhoneList = new ArrayList<String>();
		secondPhoneList.add("3");
		secondPhoneList.add("4");
		customer1.setPhoneNumbers(secondPhoneList);
		customers.put("2", customer1);
	}
}
