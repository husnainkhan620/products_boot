package com.electronics.products.data;

import java.util.List;

public class ProductHolder {
	
	private String productName;
	private Integer productQuantity;
	private List<SubProductHolder> subProduct;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public List<SubProductHolder> getSubProduct() {
		return subProduct;
	}
	public void setSubProduct(List<SubProductHolder> subProduct) {
		this.subProduct = subProduct;
	}

	

}
