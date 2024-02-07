package com.electronics.products.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.electronics.products.data.ProductCategory;
import com.electronics.products.data.ProductSubCategory;

@Repository
public class JdbcProductSubCategoryRepository implements ProductSubCategoryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ProductSubCategory> findByProductCategory(String productCategoryId) {
		
		return jdbcTemplate.query("select productCategoryId,productCategoryName,productSubCategoryId,productSubCategoryName,productSubCategoryQuantity from product_sub_Category where productCategoryId ="+productCategoryId, new RowMapper<ProductSubCategory>() {
			public ProductSubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				  Integer productCategoryId = rs.getInt("productCategoryId");
				  String productCategoryName = rs.getString("productCategoryName");
				  Integer productSubCategoryId = rs.getInt("productSubCategoryId");
				  String productSubCategoryName = rs.getString("productSubCategoryName");
				  Integer productSubCategoryQuantity = rs.getInt("productSubCategoryQuantity");
				  
				  ProductSubCategory productSubCategory = new ProductSubCategory();
				  productSubCategory.setProductCategoryId(productCategoryId);
				  productSubCategory.setProductCategoryName(productCategoryName);
				  productSubCategory.setProductSubCategoryId(productSubCategoryId);
				  productSubCategory.setProductSubCategoryName(productSubCategoryName);
				  productSubCategory.setProductSubCategoryQuantity(productSubCategoryQuantity);
				  
				return productSubCategory;
			}
		} );

	}
	
	
	@Override
	public List<ProductSubCategory> findAll() {
			
			return jdbcTemplate.query("select productCategoryId,productCategoryName from product_Category ", new RowMapper<ProductSubCategory>() {
				public ProductSubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
					  Integer productCategoryId = rs.getInt("productCategoryId");
					  String productCategoryName = rs.getString("productCategoryName");
					  
					  ProductSubCategory productSubCategory = new ProductSubCategory();
					  productSubCategory.setProductCategoryId(productCategoryId);
					  productSubCategory.setProductCategoryName(productCategoryName);
					  
					return productSubCategory;
				}
			} );

	}

	@Override
	public ProductSubCategory findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductSubCategory save(ProductSubCategory ingrediant) {
		// TODO Auto-generated method stub
		return null;
	}



}
