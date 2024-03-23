package com.electronics.products.data;

import javax.persistence.Column;


public class Product {
	
	@Column
	private Integer productId;
	@Column
	private String productName;
	@Column
	private Integer productSubCategoryId;
	@Column
	private String productSubCategoryName;
	@Column
	private Integer productCategoryId;
	@Column
	private String productCategoryName;
	@Column
	private Boolean productActive;
	@Column
	private String skucode;
	@Column
	private Integer productQuantity;
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
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
	public Boolean getProductActive() {
		return productActive;
	}
	public void setProductActive(Boolean productActive) {
		this.productActive = productActive;
	}
	public String getSkucode() {
		return skucode;
	}
	public void setSkucode(String skucode) {
		this.skucode = skucode;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}	
	
	
}
