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
	public ProductCategory save(ProductCategory ingrediant) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
