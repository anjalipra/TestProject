package com.test.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="phone")
public class Phone {
	private String phoneNumber;
	private boolean isActive;
	private int phoneId;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	
}
