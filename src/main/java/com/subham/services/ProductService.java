package com.subham.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.subham.dto.ProductDTO;
import com.subham.exceptions.ProductNotFoundExecption;
import com.subham.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public String addProduct(ProductDTO prod) {
		return repo.addProduct(prod);
	}
	
	public ArrayList<ProductDTO> getProductByName(String name){
		return repo.getProductByName(name);
	}
	
	public ArrayList<ProductDTO> getProduct(){
		return repo.getProduct();
	}
	
	public String deleteProduct(long prodCode) throws  ProductNotFoundExecption{
		return repo.deleteProduct(prodCode);
	}
}
