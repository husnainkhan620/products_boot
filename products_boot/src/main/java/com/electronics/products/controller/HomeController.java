package com.electronics.products.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.electronics.products.data.ProductCategory;
import com.electronics.products.data.ProductHolder;
import com.electronics.products.data.ProductListHolder;
import com.electronics.products.data.ProductSubCategory;
import com.electronics.products.data.SubProductHolder;
import com.electronics.products.repository.JdbcProductCategoryRepository;
import com.electronics.products.repository.JdbcProductSubCategoryRepository;


@Controller
public class HomeController {
	
		@Autowired
	    JdbcTemplate jdbcTemplate;
	
		@Autowired
		JdbcProductCategoryRepository jdbcProductCategoryRepository;
		
		@Autowired
		JdbcProductSubCategoryRepository jdbcProductSubCategoryRepository; 
		
		@GetMapping("/test1")
		public ResponseEntity<Map<String, String>> test1(HttpServletRequest request) {
			
			System.out.print(jdbcTemplate);
			
			System.out.print("Request"+request);
			
			  Map<String, String> data = new HashMap<>();
		      data.put("key1", "value1");
		      data.put("key2", "value2");
		       
		      return new ResponseEntity<>(data, HttpStatus.OK);
			
		}
		
		@GetMapping("/test2")
		public ResponseEntity<List<ProductHolder>> test2(HttpServletRequest request) {
			
				ProductListHolder productListHolder = new ProductListHolder();
				List<ProductHolder> productHolderList = new ArrayList<ProductHolder>();
				
				ProductHolder productHolder ;
				SubProductHolder subProductHolder;
				
				List<ProductCategory> productCategoryList = jdbcProductCategoryRepository.findAll();
				
				for(ProductCategory productCategory : productCategoryList) {
					System.out.println(productCategory.getProductCategoryId() + "  "+productCategory.getProductCategoryName() +"  "+ productCategory.getProductCategoryQuantity());
					
					productHolder = new ProductHolder();
					productHolder.setProductName(productCategory.getProductCategoryName());
					productHolder.setProductQuantity( productCategory.getProductCategoryQuantity());
					
					
					List<SubProductHolder> subProductHolderList = new ArrayList<SubProductHolder>();
					List<ProductSubCategory> productSubCategoryList = jdbcProductSubCategoryRepository.findByProductCategory(String.valueOf(productCategory.getProductCategoryId()));
					for(ProductSubCategory productSubCategory : productSubCategoryList) {
						System.out.println(productSubCategory.getProductSubCategoryId() + "  "+productSubCategory.getProductSubCategoryName() + "  "+productSubCategory.getProductSubCategoryQuantity());
						
						subProductHolder = new SubProductHolder();
						subProductHolder.setSubproductName(productSubCategory.getProductSubCategoryName());
						subProductHolder.setSubProductQuantity(productSubCategory.getProductSubCategoryQuantity());
			
						subProductHolderList.add(subProductHolder);
					}  
					productHolder.setSubProductHolder(subProductHolderList);
					productHolderList.add(productHolder);
				}	
				
				return new ResponseEntity<>(productHolderList, HttpStatus.OK);
			
		}

}
