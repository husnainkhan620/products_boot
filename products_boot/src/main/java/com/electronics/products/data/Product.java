package com.electronics.products.data;

import javax.persistence.Column;
import javax.persistence.Entity;


public class Product {
	
	@Column
	private Integer productId;
	@Column
	private String productName;
	@Column
	private Integer productSubCategoryId;
	@Column
	private String productSubCategotyName;
	@Column
	private Integer productCategoryId;
	@Column
	private Integer productCategotyName;
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
	public String getProductSubCategotyName() {
		return productSubCategotyName;
	}
	public void setProductSubCategotyName(String productSubCategotyName) {
		this.productSubCategotyName = productSubCategotyName;
	}
	public Integer getProductCategoryId() {
		return productCategoryId;
	}
	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
	public Integer getProductCategotyName() {
		return productCategotyName;
	}
	public void setProductCategotyName(Integer productCategotyName) {
		this.productCategotyName = productCategotyName;
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
