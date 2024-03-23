package com.electronics.products.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.electronics.products.data.Product;
import com.electronics.products.data.ProductSubCategory;

public interface ProductRepository {
	
	Page<Product> findAll(PageRequest pageRequest);
	
	Product findOne(String id);
	
	Product save(Product product);
	
	int getNewProductId(String productSubCategroyName);
	
	Page<Product> getProductsByProductCategoryName(PageRequest pageRequest,String productCategoryName);
	
	Page<Product> getProductsByProductSubCategoryName(PageRequest pageRequest,String productCategoryName,String productSubCategoryName);
	
	Product getProductsByProductCategoryId(Integer productCategoryId);
	
	Product getProductsByProductSubCategoryId(Integer productSubCategoryId);
	
	Product getProductDetialsByProductName(String productName);
	

}
