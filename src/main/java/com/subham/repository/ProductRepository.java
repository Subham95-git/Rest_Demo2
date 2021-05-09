package com.subham.repository;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.subham.dto.ProductDTO;
import com.subham.exceptions.ProductNotFoundExecption;

@Repository
public class ProductRepository {
	
	ArrayList<ProductDTO> products = null;
	
	  @PostConstruct
	  public void init() { 
	  ProductDTO product = new ProductDTO();
	  
	  product.setProductCode(101); 
	  product.setProductName("Popcorn");
	  product.setProductPrice(135); 
	  product.setProductInStock(2000);
	  product.setProductVendor("ACT II"); 
	  
	  products = new ArrayList<>();
	  products.add(product);
	  
	  }
	 

	public String addProduct(ProductDTO prod) {
		
		int size = products.size();
		products.add(prod);
		if(products.size()>size) {
			return "product details of: "+prod.getProductName()+" added successfully...";
		}
		else {
			return "Error!! product details of: "+prod.getProductName()+" not added ";
		}
	}
	
	public ArrayList<ProductDTO> getProductByName(String name){
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		
		for(ProductDTO pr: products) {
			if(pr.getProductName().equals(name)) {
				result.add(pr);
			}
		}
		
		return result;
	}
	
	public ArrayList<ProductDTO> getProduct(){
		return products;
	}
	
	public String deleteProduct(long prodCode) throws ProductNotFoundExecption {
		String response = "No such Product code: "+prodCode;
		
		boolean check = true;
		
		for(ProductDTO pr: products) {
			if(pr.getProductCode()==prodCode) {
				products.remove(pr);
				response = "Product with code "+prodCode+" deleted successfully...";
				check = false;
			}
		}
		
		if(check) {
			throw new ProductNotFoundExecption("Product not found! Please check the product code...");
		}
		return response;
	}
}
