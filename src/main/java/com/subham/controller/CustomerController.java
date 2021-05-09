package com.subham.controller;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.subham.dto.CustomerDTO;
import com.subham.dto.ErrorMessage;
import com.subham.dto.PlanDTO;
import com.subham.dto.ProductDTO;
import com.subham.exceptions.NoSuchCustomerException;
import com.subham.exceptions.ProductNotFoundExecption;
import com.subham.services.CustomerService;
import com.subham.services.ProductService;

//import java.time.DayOfWeek;
//import java.time.LocalDate;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService prodService;
	
	//To get all the Customer Details
	@GetMapping(produces = "application/json")
	public List<CustomerDTO> fetchCustomer() {
		//DayOfWeek day = LocalDate.now().getDayOfWeek();
		return customerService.fetchCustomer();
	}
	
	//To get all the Product Details
	@GetMapping(value = "/product",produces = "application/json")
	public List<ProductDTO> fetchProduct() {
		//DayOfWeek day = LocalDate.now().getDayOfWeek();
		return prodService.getProduct();
	}
	
	//To get Product by Product name
	@GetMapping(value = "/product/{productName}", produces = "application/json")
	public List<ProductDTO> fetchProductByName(@PathVariable("productName")String name) {
		//DayOfWeek day = LocalDate.now().getDayOfWeek();
		return prodService.getProductByName(name);
	}
	
	
	//This will add new Customer Details
	@PostMapping(consumes = "application/json")
	public ResponseEntity createCustomer(@Valid @RequestBody CustomerDTO customerDTO, Errors errors) {

		String response = "";
		if(errors.hasErrors()) {
			
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			
			ErrorMessage error = new ErrorMessage();
			
			error.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
			error.setErrorMessgae(response);
			
			return ResponseEntity.ok(error);
		}else {
			PlanDTO plan = new RestTemplate().getForObject(
					"httphttp://localhost:8080/plans/"+customerDTO.getCurrentPlan().getPlanID(),PlanDTO.class);
			customerDTO.setCurrentPlan(plan);
			response = customerService.createCustomer(customerDTO);
			return ResponseEntity.ok(response);
		}
		
	}
	
	//This will add new Product
	@PostMapping(value = "/product", consumes = "application/json")
	public ResponseEntity<String> addProduct(@RequestBody ProductDTO prod){
		String response = prodService.addProduct(prod);
		return ResponseEntity.ok(response);
	}
	
	// It will update customer depending on phone number 
	@PutMapping(value = "/{phoneNumber}", consumes = "application/json")
	public String updateCustomer(@PathVariable("phoneNumber")long phoneNo,
			@RequestBody CustomerDTO customerDTO) {
		return customerService.updateCustomer(phoneNo, customerDTO);
	}
	
	//It will delete the Customer depending on Phone number
	@DeleteMapping("/{phoneNumber}")
	public String deleteCustomer(@PathVariable("phoneNumber") long phoneNumber)throws NoSuchCustomerException {
		return customerService.deleteCustomer(phoneNumber);
	}
	
	//It will delete the product based on product code
	@DeleteMapping("/product/{product_code}")
	public String deleteProduct(@PathVariable("product_code") long prodCode) throws ProductNotFoundExecption{
		return prodService.deleteProduct(prodCode);
	}
}
