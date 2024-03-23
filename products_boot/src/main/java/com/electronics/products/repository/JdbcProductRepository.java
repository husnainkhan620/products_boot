package com.electronics.products.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.electronics.products.data.Product;

@Repository
public class JdbcProductRepository implements ProductRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Page<Product> findAll(PageRequest pageRequest) {
	
		System.out.println("page size-->"+pageRequest.getPageSize());
		System.out.println("page offset--->"+pageRequest.getOffset());
		
		Integer productsCount  = jdbcTemplate.queryForObject(
                "select count(productId) as product_count from PRODUCT",Integer.class
        );
		
		System.out.println("All product count "+productsCount);
		
		List<Product> products =   jdbcTemplate.query("select * from PRODUCT limit ? offset ?", 
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {				
						Product product= new Product();
						product.setProductId(rs.getInt("productId"));
						product.setProductName(rs.getString("productName"));
						product.setProductSubCategoryId(rs.getInt("productSubCategoryId"));
						product.setProductSubCategoryName(rs.getString("productSubCategoryName"));
						product.setProductCategoryId(rs.getInt("productCategoryId"));
						product.setProductCategoryName(rs.getString("productCategoryName"));
						product.setProductActive(rs.getBoolean("productActive"));
						product.setSkucode(rs.getString("skucode"));
						product.setProductQuantity(rs.getInt("productQuantity"));
						return product;
					}
					
				},pageRequest.getPageSize(),pageRequest.getOffset());
		
		
		return new PageImpl<Product>(products,pageRequest,productsCount);
	}
	

	@Override
	public Product findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product save(Product product) {
		
		jdbcTemplate.update("insert into PRODUCT(productId,productName,productSubCategoryId,productSubCategoryName,productCategoryId,productCategoryName,productActive,skucode,productQuantity) "
				+ "values(?,?,?,?,?,?,?,?,?)",product.getProductId(),product.getProductName(),product.getProductSubCategoryId(),product.getProductSubCategoryName(),
				product.getProductCategoryId(),product.getProductCategoryName(),product.getProductActive(),product.getSkucode(),product.getProductQuantity());
		
		System.out.println("New Product inserted successfully");
		return product;
	}

	@Override
	public int getNewProductId(String productSubCategroyName) {
		
		int result = jdbcTemplate.queryForObject("select max(productId) from PRODUCT where productSubCategoryName = ?", Integer.class,productSubCategroyName);
		return result + 1;
	}

	@Override
	public Page<Product> getProductsByProductCategoryName(PageRequest pageRequest,String productCategoryName) {
		
		Integer productsByCategoryCount  = jdbcTemplate.queryForObject(
                "select count(productId) as productsByCategoryCount  from PRODUCT where productCategoryName = ?",Integer.class,productCategoryName
        );
		
		System.out.println("All products By Category count "+productsByCategoryCount);
		
		List<Product> products =   jdbcTemplate.query("select * from PRODUCT where productCategoryName = ? limit ? offset ?", 
				new RowMapper<Product>() {

					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {				
						Product product= new Product();
						product.setProductId(rs.getInt("productId"));
						product.setProductName(rs.getString("productName"));
						product.setProductSubCategoryId(rs.getInt("productSubCategoryId"));
						product.setProductSubCategoryName(rs.getString("productSubCategoryName"));
						product.setProductCategoryId(rs.getInt("productCategoryId"));
						product.setProductCategoryName(rs.getString("productCategoryName"));
						product.setProductActive(rs.getBoolean("productActive"));
						product.setSkucode(rs.getString("skucode"));
						product.setProductQuantity(rs.getInt("productQuantity"));
						return product;
					}
					
				},productCategoryName,pageRequest.getPageSize(),pageRequest.getOffset());
		
		System.out.println(products.toString());
		
		return new PageImpl<Product>(products,pageRequest,productsByCategoryCount);
		
	}

	@Override
	public Page<Product> getProductsByProductSubCategoryName(PageRequest pageRequest,String productCategoryName,String productSubCategoryName) {
	
		Integer productsByCategoryCount  = jdbcTemplate.queryForObject(
                "select count(productId) as productsByCategoryCount  from PRODUCT where productCategoryName = ? and productSubCategoryName = ?",Integer.class,productCategoryName,productSubCategoryName
        );
		
		System.out.println("All products By Sub Category Category count "+productsByCategoryCount);
		
		List<Product> products =   jdbcTemplate.query("select * from PRODUCT where productCategoryName = ? and productSubCategoryName = ? limit ? offset ?", 
				new RowMapper<Product>() {
 
					@Override
					public Product mapRow(ResultSet rs, int rowNum) throws SQLException {				
						Product product= new Product();
						product.setProductId(rs.getInt("productId"));
						product.setProductName(rs.getString("productName"));
						product.setProductSubCategoryId(rs.getInt("productSubCategoryId"));
						product.setProductSubCategoryName(rs.getString("productSubCategoryName"));
						product.setProductCategoryId(rs.getInt("productCategoryId"));
						product.setProductCategoryName(rs.getString("productCategoryName"));
						product.setProductActive(rs.getBoolean("productActive"));
						product.setSkucode(rs.getString("skucode"));
						product.setProductQuantity(rs.getInt("productQuantity"));
						return product;
					}
					
				},productCategoryName,productSubCategoryName,pageRequest.getPageSize(),pageRequest.getOffset());
		
		
		return new PageImpl<Product>(products,pageRequest,productsByCategoryCount);
		

		
	}

	@Override
	public Product getProductsByProductCategoryId(Integer productCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProductsByProductSubCategoryId(Integer productSubCategoryId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Product getProductDetialsByProductName(String productName) {
		
		return  jdbcTemplate.queryForObject("select * from PRODUCT where productName = ?", new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product= new Product();
				product.setProductId(rs.getInt("productId"));
				product.setProductName(rs.getString("productName"));
				product.setProductSubCategoryId(rs.getInt("productSubCategoryId"));
				product.setProductSubCategoryName(rs.getString("productSubCategoryName"));
				product.setProductCategoryId(rs.getInt("productCategoryId"));
				product.setProductCategoryName(rs.getString("productCategoryName"));
				product.setProductActive(rs.getBoolean("productActive"));
				product.setSkucode(rs.getString("skucode"));
				product.setProductQuantity(rs.getInt("productQuantity"));
				return product;
			}
		},productName);
		
	}

}
