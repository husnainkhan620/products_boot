package com.electronics.products.data;

import java.util.List;

public class ProductHolder {
	
	private String productName;
	private Integer productQuantity;
	private List<SubProductHolder> subProductHolder;
	
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
	public List<SubProductHolder> getSubProductHolder() {
		return subProductHolder;
	}
	public void setSubProductHolder(List<SubProductHolder> subProductHolder) {
		this.subProductHolder = subProductHolder;
	}
	
	

}
