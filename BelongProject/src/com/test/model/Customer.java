package com.test.model;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="customer")
public class Customer {
	private int customerId;
	private String customerName;
	private List<Phone> phoneNumbersList;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Phone> getPhoneNumbersList() {
		return phoneNumbersList;
	}
	public void setPhoneNumbersList(List<Phone> phoneNumbersList) {
		this.phoneNumbersList = phoneNumbersList;
	}

	
}
