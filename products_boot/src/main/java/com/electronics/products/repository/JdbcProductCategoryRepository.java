package com.electronics.products.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.electronics.products.data.ProductCategory;

@Repository
public class JdbcProductCategoryRepository implements ProductCategoryRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductCategory> findAll() {
	
		
		return jdbcTemplate.query("select productCategoryId,productCategoryName,productCategoryQuantity from product_Category ", new RowMapper<ProductCategory>() {
			public ProductCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				  Integer productCategoryId = rs.getInt("productCategoryId");
				  String productCategoryName = rs.getString("productCategoryName");
				  Integer productCategoryQuantity = rs.getInt("productCategoryQuantity");
				  
				  ProductCategory productCategory = new ProductCategory();
				  productCategory.setProductCategoryId(productCategoryId);
				  productCategory.setProductCategoryName(productCategoryName);
				  productCategory.setProductCategoryQuantity(productCategoryQuantity);
				  
				return productCategory;
			}
		} );
	}

	@Override
	public ProductCategory findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductCategory save(ProductCategory productCategory) {
		// TODO Auto-generated method stub
		 jdbcTemplate.update("insert into product_Category values(?,?,?)",productCategory.getProductCategoryId(),productCategory.getProductCategoryName(),productCategory.getProductCategoryQuantity());
		 
		 System.out.print("New Product Inserted successfully");
		 return productCategory;
	}

	@Override
	public Integer getNewProductCategoryId() {
		
		Integer result = jdbcTemplate.queryForObject("select max(productCategoryId) from product_Category", Integer.class);
		return result;
	}

	@Override
	public ProductCategory getProductCategoryDetailsByName(String productCategoryName) {
	
		return jdbcTemplate.queryForObject("select * from PRODUCT_CATEGORY where productCategoryName = ?", new RowMapper<ProductCategory>() {

			@Override
			public ProductCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				ProductCategory productCategory = new ProductCategory();
				productCategory.setProductCategoryId(rs.getInt("productCategoryId"));
				productCategory.setProductCategoryName(rs.getString("productCategoryName"));
				productCategory.setProductCategoryQuantity(rs.getInt("productCategoryQuantity"));
				
				return productCategory;
			}
		},productCategoryName);
	}
	
	
}
