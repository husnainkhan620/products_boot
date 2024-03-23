package com.electronics.products.repository;

import java.util.List;

import com.electronics.products.data.ProductCategory;



public interface ProductCategoryRepository {
	
	List<ProductCategory> findAll();
	
	ProductCategory findOne(String id);
	
	ProductCategory save(ProductCategory ingrediant);

	Integer getNewProductCategoryId();
	
	ProductCategory getProductCategoryDetailsByName(String productCategoryName);
}
