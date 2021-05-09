package com.subham.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.dto.CustomerDTO;
import com.subham.exceptions.NoSuchCustomerException;
import com.subham.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	//makes a call to Repository to add customer
	public String createCustomer(CustomerDTO customer) {
		customerRepository.createCustomer(customer);
		
		return "Customer "+customer.getName()+" added successfully...";
	}
	
	//makes a call to repository to get all customer
	public List<CustomerDTO> fetchCustomer(){
		
		return customerRepository.fetchCustomer();
		
	}
	
	/* makes a call to repository method for fetching the customers list and
	 * updates the customer's details 
	 */
	
	public String updateCustomer(long phoneNo, CustomerDTO customer) {
		
		String response = "Customer of "+customer.getPhoneNo()+" does not exist";
		
		for(CustomerDTO cust: customerRepository.fetchCustomer()) {
			if(cust.getPhoneNo()==phoneNo) {
				if(customer.getName()!=null) {
					cust.setName(customer.getName());
				}
				if(customer.getPassword()!=null) {
					cust.setPassword(customer.getPassword());
				}
				if(customer.getAddress()!=null) {
					cust.setAddress(customer.getAddress());
				}
				
				response = "Customer of phoneNumber "+customer.getName()+" got updated successfully";
				break;
			}
		}
		return response;
	}
	
	
	/* makes a call to repository method for fetching the customers list and
	 * then calls the repository's deleteCustomer() method with the customer to be deleted 
	 */
	
	public String deleteCustomer(long phoneNo) throws NoSuchCustomerException{
		String response = "Customer of: "+phoneNo+" does not exist";
		boolean check = true;
		for (CustomerDTO customer : customerRepository.fetchCustomer()) {
			if (customer.getPhoneNo() == phoneNo) {
				
				customerRepository.deleteCustomer(customer);
				
				response = customer.getName() + " of phoneNumber " + customer.getPhoneNo()
						+ " got deleted successfully";
				check=false;
				break;
			}
		}
		
		if(check) {
			throw new NoSuchCustomerException("Customer does not exist with phone number: "+phoneNo);
		}
		 
		return response;
	}
}
