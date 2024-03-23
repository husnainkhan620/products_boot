package com.electronics.products.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.electronics.products.data.ProductSubCategory;

@Repository
public class JdbcProductSubCategoryRepository implements ProductSubCategoryRepository { 

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ProductSubCategory> findByProductCategoryId(String productCategoryId) {
		
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
	public List<ProductSubCategory> findAllProductSubCategories() {
			
			return jdbcTemplate.query("select productSubCategoryId,productCategoryName from PRODUCT_SUB_CATEGORY ", new RowMapper<ProductSubCategory>() {
				public ProductSubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
					  Integer productSubCategoryId = rs.getInt("productSubCategoryId");
					  String productSubCategoryName = rs.getString("productSubCategoryName");
					  
					  ProductSubCategory productSubCategory = new ProductSubCategory();
					  productSubCategory.setProductCategoryId(productSubCategoryId);
					  productSubCategory.setProductCategoryName(productSubCategoryName);
					  
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
	public ProductSubCategory save(ProductSubCategory productSubCategory) {
		System.out.println("Inserting new Product");
		System.out.println("productSubCategoryId - "+productSubCategory.getProductSubCategoryId());
		System.out.println("productSubCategoryName - "+productSubCategory.getProductSubCategoryName());
		System.out.println("productCategoryId - "+productSubCategory.getProductCategoryId());
		System.out.println("productCategoryName - "+productSubCategory.getProductCategoryName());
		System.out.println("productSubCategoryQuantity - "+productSubCategory.getProductSubCategoryQuantity());
		
		jdbcTemplate.update("insert into PRODUCT_SUB_CATEGORY(productSubCategoryId,productSubCategoryName,productCategoryId,productCategoryName,productSubCategoryQuantity) values(?,?,?,?,?)",productSubCategory.getProductSubCategoryId(),productSubCategory.getProductSubCategoryName(),productSubCategory.getProductCategoryId(),productSubCategory.getProductCategoryName(),productSubCategory.getProductSubCategoryQuantity());
		System.out.println("New Product SubCategory inserted successfully");
		
		return productSubCategory; 
	}

	@Override
	public int getNewProductSubcategoryId(String productCategoryName) {
		
		Integer result = jdbcTemplate.queryForObject("select max(productSubCategoryId) from PRODUCT_SUB_CATEGORY where productCategoryName = ?", Integer.class,productCategoryName);
		return result;
	}


	@Override
	public ProductSubCategory getProductSubCategoryDetailsByName(String productSubCategoryName) {
		return jdbcTemplate.queryForObject("select * from PRODUCT_SUB_CATEGORY where productSubCategoryName = ?", new RowMapper<ProductSubCategory>() {

			@Override
			public ProductSubCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ProductSubCategory productSubCategory = new ProductSubCategory();
				productSubCategory.setProductCategoryId(rs.getInt("productCategoryId"));
				productSubCategory.setProductCategoryName(rs.getString("productCategoryName"));
				productSubCategory.setProductSubCategoryId(rs.getInt("productSubCategoryId"));
				productSubCategory.setProductSubCategoryName(rs.getString("productSubCategoryName"));
				productSubCategory.setProductSubCategoryQuantity(rs.getInt("productSubCategoryQuantity"));
				
				return productSubCategory;
			}
		},productSubCategoryName);
	}

	// Like under Embedded Electronics(product category) we have Development(sub product category) with 17 products
	@Override
	public List<ProductSubCategory> findByProductCategoryName(String productCategoryName) {
	
				
		return jdbcTemplate.query("select productCategoryId,productCategoryName,productSubCategoryId,productSubCategoryName,productSubCategoryQuantity from product_sub_Category where productCategoryName = ?", new RowMapper<ProductSubCategory>() {
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
		},productCategoryName );

	}




}
