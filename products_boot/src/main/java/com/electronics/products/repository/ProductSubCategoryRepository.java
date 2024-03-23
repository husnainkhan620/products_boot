package com.electronics.products.repository;

import java.util.List;

import com.electronics.products.data.ProductSubCategory;

public interface ProductSubCategoryRepository {
	
	List<ProductSubCategory> findAllProductSubCategories();
	
	List<ProductSubCategory> findByProductCategoryId(String productCategoryId);
	
	ProductSubCategory findOne(String id);
	
	ProductSubCategory save(ProductSubCategory ingrediant);
	
	int getNewProductSubcategoryId(String productCategoryName);
	
	ProductSubCategory getProductSubCategoryDetailsByName(String productSubCategoryName);
	
	List<ProductSubCategory>  findByProductCategoryName(String productCategoryName);
}
