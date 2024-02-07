package com.electronics.products.data;

import javax.persistence.Column;
import javax.persistence.Entity;

 
public class ProductCategory {
	
	@Column
	private Integer productCategoryId;
	@Column
	private String productCategoryName;
	@Column
	private Integer productCategoryQuantity;
	
	public Integer getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public Integer getProductCategoryQuantity() {
		return productCategoryQuantity;
	}
	public void setProductCategoryQuantity(Integer productCategoryQuantity) {
		this.productCategoryQuantity = productCategoryQuantity;
	}
	
	
}
