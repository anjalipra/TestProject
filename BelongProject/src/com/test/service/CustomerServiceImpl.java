package com.test.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.test.model.Customer;
import com.test.model.Phone;
import com.test.model.Response;

@Path("/customer")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class CustomerServiceImpl implements CustomerService {

	//Static customer data 
	private static Map<Integer, Customer> customers = new HashMap<Integer, Customer>();
	
	@Override
	@POST
    @Path("/add")
	public Response addCustomer() {
		Response response = new Response();

		Customer customer = new Customer();
		customer.setCustomerName("Anjali");
		customer.setCustomerId(1);

		Phone p1 = new Phone();
		p1.setActive(true);
		p1.setPhoneNumber("12345");
		p1.setPhoneId(1);
		Phone p2 = new Phone();
		p2.setActive(true);
		p2.setPhoneNumber("67890");
		p2.setPhoneId(2);
		List<Phone> phoneList = new ArrayList<Phone>();
		phoneList.add(p1);
		phoneList.add(p2);

		customer.setPhoneNumbersList(phoneList);
		customers.put(1, customer);

		Customer customer1 = new Customer();
		customer1.setCustomerName("Prakash");
		customer1.setCustomerId(2);

		Phone p11 = new Phone();
		p11.setActive(true);
		p11.setPhoneNumber("12345123");
		p11.setPhoneId(3);
		Phone p22 = new Phone();
		p22.setActive(true);
		p22.setPhoneNumber("678905678");
		p22.setPhoneId(4);
		List<Phone> phoneList11 = new ArrayList<Phone>();
		phoneList11.add(p11);
		phoneList11.add(p22);

		customer1.setPhoneNumbersList(phoneList11);
		customers.put(2, customer1);
		
		response.setMessage("Customer Data created successfully");
		return response;
	}
	

	@Override
	@GET
	@Path("/getAll")
	public List<Phone> getAllPhoneNumbers() {
		List<Phone> phoneList = new ArrayList<Phone>();
		
		Set<Integer> ids = customers.keySet();
		for(Integer id : ids){
			phoneList.addAll(customers.get(id).getPhoneNumbersList());
		}
		return phoneList;
	}
	
	@Override
	@GET
	@Path("/{id}/getAll")
	public List<Phone> getAllPhoneNumbersOfCustomer(@PathParam("id") int id) {
		return customers.get(id).getPhoneNumbersList();
	}
	
	@Override
	@PUT
    @Path("/{id}/activate")
	public Response activatePhoneNumber(@PathParam("id") String phoneNumber) {
		Response response = new Response();
		response.setStatus(false);
		response.setMessage("Phone number do not exists");
		
		List<Phone> phoneList = new ArrayList<Phone>();
		
		Set<Integer> ids = customers.keySet();
		for(Integer id : ids){
			phoneList = customers.get(id).getPhoneNumbersList();
			
			for(Phone phone: phoneList) {
				if(phoneNumber.equals(phone.getPhoneNumber())) {
					phone.setActive(true);
					customers.put(id, customers.get(id));
					
					response.setStatus(true);
					response.setMessage("Phone number activated");
					return response;
				}
			}
		}
		return response;
	}
}
