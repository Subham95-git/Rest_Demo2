package com.subham.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.subham.dto.CustomerDTO;
import com.subham.dto.FriendFamilyDTO;
import com.subham.dto.PlanDTO;

@Repository
public class CustomerRepository {

	List<CustomerDTO> customers = null;

	@PostConstruct
	public void init() {
		CustomerDTO customerDTO = new CustomerDTO();
		PlanDTO planDTO = new PlanDTO();

		planDTO.setPlanID(1);
		planDTO.setPlanName("Simple");
		planDTO.setInternationalRate(3);
		planDTO.setNationalRate(5);

		customerDTO.setAddress("Chennai");
		customerDTO.setAge(18); 
		customerDTO.setCurrentPlan(planDTO);
		customerDTO.setGender('m');
		customerDTO.setName("Jack"); 
		customerDTO.setEmail("Jack@infy.com");
		customerDTO.setPassword("ABC@123"); 
		customerDTO.setPhoneNo(9951212222l);

		List<FriendFamilyDTO> friendAndFamily = new ArrayList<>();
		customerDTO.setFriendFamily(friendAndFamily);
		friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(),800000145));
		friendAndFamily.add(new FriendFamilyDTO(customerDTO.getPhoneNo(),700000145));

		customers = new ArrayList<>();
		customers.add(customerDTO);
	}

	//Add customer
	public void createCustomer(CustomerDTO customer) {
		customers.add(customer);
	}

	//return a list of customers
	public List<CustomerDTO> fetchCustomer(){
		return customers;
	}

	//deletes the passed customer from the list
	public void deleteCustomer(CustomerDTO customer)
	{
		customers.remove(customer);
	}
}
