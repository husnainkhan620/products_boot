package com.electronics.products.repository;

import java.util.List;

import com.electronics.products.data.ProductSubCategory;

public interface ProductSubCategoryRepository {
	
	List<ProductSubCategory> findAll();
	
	List<ProductSubCategory> findByProductCategory(String productCategoryId);
	
	ProductSubCategory findOne(String id);
	
	ProductSubCategory save(ProductSubCategory ingrediant);

}
