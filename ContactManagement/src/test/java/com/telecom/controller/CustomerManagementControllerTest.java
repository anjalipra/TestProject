package com.telecom.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.telecom.model.ContactInformation;
import com.telecom.model.Customer;
import com.telecom.service.ContactService;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerManagmentController.class)
public class CustomerManagementControllerTest {
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private ContactService contactService;
    
    @Test
    public void getAllContactsTest() throws Exception {
    	
    	ContactInformation contact = new ContactInformation();
		contact.setContactId("1");
		contact.setCountryCode("+61");
		contact.setPhoneNumber("123 456 678");
		contact.setType("HOME");
		contact.setActive(true);
		contact.setCustomerId("1");
		
        List<ContactInformation> contacts = new ArrayList<>();
        contacts.add(contact);

        Mockito.when(contactService.getAllContacts()).thenReturn(contacts);

        mvc.perform(MockMvcRequestBuilders.get("/contacts/getAll")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", IsCollectionWithSize.hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].contactId", is("1")));
    }
    
    
    @Test
    public void getContactsByCustomerIdTest() throws Exception {
    	ContactInformation contact = new ContactInformation();
		contact.setContactId("1");
		contact.setCountryCode("+61");
		contact.setPhoneNumber("123 456 678");
		contact.setType("HOME");
		contact.setActive(true);
		contact.setCustomerId("3");
		
        List<ContactInformation> contacts = new ArrayList<>();
        contacts.add(contact);

        Customer customer = new Customer();

        customer.setCustomerId("3");
        customer.setFirstName("Test");
        customer.setLastName("Last");
        
		List<String> firstPhoneList = new ArrayList<String>();
		firstPhoneList.add("1");
		
        customer.setPhoneNumbers(firstPhoneList);

        Mockito.when(contactService.getContactsByCustomerId(customer.getCustomerId())).thenReturn(contacts);
        mvc.perform(MockMvcRequestBuilders.get("/contacts/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].contactId", is("1")))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].phoneNumber ", is("123 456 678")));
    }
	
    @Test
    public void activateNumberTest() throws Exception {
    	ContactInformation contact = new ContactInformation();
		contact.setContactId("3");
		contact.setCountryCode("+61");
		contact.setPhoneNumber("123 456 678");
		contact.setType("HOME");
		contact.setActive(true);
		contact.setCustomerId("3");
		
        List<ContactInformation> contacts = new ArrayList<>();
        contacts.add(contact);
        
        mvc.perform(MockMvcRequestBuilders.put("/contacts/update/3")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
               	.andExpect(MockMvcResultMatchers.content().string("Successfully activated the contact number."));
    }
	
}
