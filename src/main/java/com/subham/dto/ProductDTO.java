package com.subham.dto;

public class ProductDTO {

	long productCode;
	String productName;
	String productVendor;
	double productPrice;
	int productInStock;
	
	//Constructor
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(long productCode, String productName, String productVendor, double productPrice,
			int productInStock) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productVendor = productVendor;
		this.productPrice = productPrice;
		this.productInStock = productInStock;
	}



	//Getter Setter
	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(int productInStock) {
		this.productInStock = productInStock;
	}
	
	
	
}
