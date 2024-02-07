package com.electronics.products.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity(name = "PRODUCTSUBCATEGORY")
public class ProductSubCategory {

	//@Id
	@Column
	private Integer productSubCategoryId ;
	@Column
	private String productSubCategoryName ;
	@Column
	private Integer productCategoryId ;
	@Column
	private String productCategoryName ;
	@Column
	private Integer productSubCategoryQuantity;
	
	public Integer getProductSubCategoryId() {
		return productSubCategoryId;
	}
	public void setProductSubCategoryId(Integer productSubCategoryId) {
		this.productSubCategoryId = productSubCategoryId;
	}
	public String getProductSubCategoryName() {
		return productSubCategoryName;
	}
	public void setProductSubCategoryName(String productSubCategoryName) {
		this.productSubCategoryName = productSubCategoryName;
	}
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
	public Integer getProductSubCategoryQuantity() {
		return productSubCategoryQuantity;
	}
	public void setProductSubCategoryQuantity(Integer productSubCategoryQuantity) {
		this.productSubCategoryQuantity = productSubCategoryQuantity;
	}
	
}
