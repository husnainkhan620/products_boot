package com.electronics.products.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.electronics.products.data.NewProductHolder;
import com.electronics.products.data.Product;
import com.electronics.products.data.ProductCategory;
import com.electronics.products.data.ProductHolder;
import com.electronics.products.data.ProductSubCategory;
import com.electronics.products.data.SubProductHolder;
import com.electronics.products.repository.JdbcProductCategoryRepository;
import com.electronics.products.repository.JdbcProductRepository;
import com.electronics.products.repository.JdbcProductSubCategoryRepository;


@Controller
public class HomeController {
	
		@Autowired
	    JdbcTemplate jdbcTemplate;
	
		@Autowired
		JdbcProductCategoryRepository jdbcProductCategoryRepository;
		
		@Autowired
		JdbcProductSubCategoryRepository jdbcProductSubCategoryRepository; 
		
		@Autowired
		JdbcProductRepository jdbcProductRepository;
		
		//  http://localhost:8080/findAllProducts?page=0&size=10
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/findAllProducts")
		public ResponseEntity<Page<Product>> findAllProducts(@RequestParam(name = "page", defaultValue = "1") int page,
														@RequestParam(name = "size", defaultValue = "10") int size,HttpServletRequest request) {
			
			
		    PageRequest pagerequest = PageRequest.of(page, size);
		    Page<Product> productPage = jdbcProductRepository.findAll(pagerequest);
		       
		    
		    return new ResponseEntity<>(productPage, HttpStatus.OK);
			
		}
		
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/findProductSubCategoriesByProductCategoryName")
		public ResponseEntity<List<ProductSubCategory>>  findProductSubCategoriesByProductCategoryName(@RequestParam(name="productCategoryName") String productCategoryName ,HttpServletRequest request){
			
			List<ProductSubCategory> productSubCategoryList =   jdbcProductSubCategoryRepository.findByProductCategoryName(productCategoryName);
			
			return new ResponseEntity<List<ProductSubCategory>>(productSubCategoryList,HttpStatus.OK);
			
		}
		
		// http://localhost:8080/findProductsByProductCategoryName?page=0&size=10&productCategoryName=Embedded Electronics
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/findProductsByProductCategoryName")
		public ResponseEntity<Page<Product>> findProductsByProductCategoryName(@RequestParam(name = "page", defaultValue = "1") int page,
														@RequestParam(name = "size", defaultValue = "10") int size,@RequestParam(name="productCategoryName") String productCategoryName ,HttpServletRequest request) {
			
			System.out.println(request.getParameter("page"));
			System.out.println(request.getParameter("size"));
			System.out.println(request.getParameter("productCategoryName"));
			
		    PageRequest pagerequest = PageRequest.of(page, size);
		    Page<Product> productPage = jdbcProductRepository.getProductsByProductCategoryName(pagerequest,productCategoryName);
		       
		    
		    return new ResponseEntity<>(productPage, HttpStatus.OK);
			
		}
		
		// http://localhost:8080/findProductsByProductSubCategoryName?page=0&size=10&productCategoryName=Embedded%20Electronics&productSubCategoryName=Audio%20Speech
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/findProductsByProductSubCategoryName")
		public ResponseEntity<Page<Product>> findProductsByProductSubCategoryName(@RequestParam(name = "page", defaultValue = "0") int page,
														@RequestParam(name = "size", defaultValue = "10") int size,@RequestParam(name="productCategoryName") String productCategoryName ,@RequestParam(name="productSubCategoryName") String productSubCategoryName ,HttpServletRequest request) {
			
			System.out.println(request.getParameter("page"));
			System.out.println(request.getParameter("size"));
			System.out.println(request.getParameter("productCategoryName"));
			System.out.println(request.getParameter("productSubCategoryName"));
			
		    PageRequest pagerequest = PageRequest.of(page, size);
		    Page<Product> productPage = jdbcProductRepository.getProductsByProductSubCategoryName(pagerequest,productCategoryName,productSubCategoryName);
		       
		    System.out.println(productPage.toString());
		    return new ResponseEntity<>(productPage, HttpStatus.OK);
			
		}
		
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping("/getProductDetailsByProductName")
		public ResponseEntity<Product>  getProductDetailsByProductName(@RequestParam(name="productCategoryName") String productCategoryName ,@RequestParam(name="productSubCategoryName") String productSubCategoryName ,@RequestParam(name="productName") String productName,HttpServletRequest request){
			
			System.out.print("Fetching "+productName+"  Details");
			
			Product product = jdbcProductRepository.getProductDetialsByProductName(productName);
			
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		
		
		@CrossOrigin(origins = "http://localhost:3000")
		@GetMapping(value = "/listProductsByCategory",produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<ProductHolder>> listProductsByCategory(HttpServletRequest request) {
			
				List<ProductHolder> productHolderList = new ArrayList<ProductHolder>();
				
				ProductHolder productHolder ;
				SubProductHolder subProduct;
				
				List<ProductCategory> productCategoryList = jdbcProductCategoryRepository.findAll();
				
				for(ProductCategory productCategory : productCategoryList) {
					System.out.println(productCategory.getProductCategoryId() + "  "+productCategory.getProductCategoryName() +"  "+ productCategory.getProductCategoryQuantity());
					productHolder = new ProductHolder();
					productHolder.setProductName(productCategory.getProductCategoryName());
					productHolder.setProductQuantity( productCategory.getProductCategoryQuantity());
					List<SubProductHolder> subProductList = new ArrayList<SubProductHolder>();
					List<ProductSubCategory> productSubCategoryList = jdbcProductSubCategoryRepository.findByProductCategoryId(String.valueOf(productCategory.getProductCategoryId()));
					for(ProductSubCategory productSubCategory : productSubCategoryList) {
						System.out.println(productSubCategory.getProductSubCategoryId() + "  "+productSubCategory.getProductSubCategoryName() + "  "+productSubCategory.getProductSubCategoryQuantity());
						subProduct = new SubProductHolder();
						subProduct.setSubproductName(productSubCategory.getProductSubCategoryName());
						subProduct.setSubProductQuantity(productSubCategory.getProductSubCategoryQuantity());
			
						subProductList.add(subProduct);
					}  
					productHolder.setSubProduct(subProductList);
					productHolderList.add(productHolder);
				}	
				
				return new ResponseEntity<>(productHolderList, HttpStatus.OK);	
		}
		
		@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping(value = "/addProductCategory",produces = MediaType.APPLICATION_JSON_VALUE) 
		public ResponseEntity<ProductHolder> addProductCategory(@RequestBody ProductHolder productHolder,HttpServletRequest request) {
			

			System.out.print(" Reached here "+productHolder.getProductName() + "  "+productHolder.getProductQuantity());
			
			Integer productCategoryId = jdbcProductCategoryRepository.getNewProductCategoryId();
					
			ProductCategory productCategory = new ProductCategory();
			productCategory.setProductCategoryId(productCategoryId + 1); // derive logic for new Product Category
			
			productCategory.setProductCategoryName(productHolder.getProductName());
			productCategory.setProductCategoryQuantity(productHolder.getProductQuantity());
			
			jdbcProductCategoryRepository.save(productCategory); 
			
			return new ResponseEntity<>(productHolder, HttpStatus.OK);
		}
		
		
		
		@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping(value = "/addSubProductCategory",produces = MediaType.APPLICATION_JSON_VALUE) 
		public ResponseEntity<ProductHolder> addSubProductCategory(@RequestBody ProductHolder productHolder,HttpServletRequest request) {
			

			System.out.println(" Reached here "+productHolder.getProductName() + "  "+productHolder.getProductQuantity());
			System.out.println(" Reached here "+productHolder.getSubProduct().get(0).getSubproductName() + "  "+productHolder.getSubProduct().get(0).getSubProductQuantity());
			
			ProductSubCategory productSubCategory = new ProductSubCategory();
			
			ProductCategory productCategory = jdbcProductCategoryRepository.getProductCategoryDetailsByName(productHolder.getProductName());
			
			productSubCategory.setProductCategoryId(productCategory.getProductCategoryId()); // derive logic to get existing Product category based on name
			productSubCategory.setProductCategoryName(productCategory.getProductCategoryName());
			
			Integer productSubInteger =   jdbcProductSubCategoryRepository.getNewProductSubcategoryId(productCategory.getProductCategoryName());
			productSubInteger = productSubInteger +1 ;
			System.out.println("New Product SubCategory Id "+productSubInteger);
			
			productSubCategory.setProductSubCategoryId(productSubInteger);
			productSubCategory.setProductSubCategoryName(productHolder.getSubProduct().get(0).getSubproductName());
			productSubCategory.setProductSubCategoryQuantity(productHolder.getSubProduct().get(0).getSubProductQuantity());
			
			jdbcProductSubCategoryRepository.save(productSubCategory);
					
			return new ResponseEntity<>(productHolder, HttpStatus.OK);
		}
		
		@CrossOrigin(origins = "http://localhost:3000")
		@PostMapping(value = "/addNewProduct",produces = MediaType.APPLICATION_JSON_VALUE) 
		public ResponseEntity<NewProductHolder> addNewProduct(@RequestBody NewProductHolder newProductHolder,HttpServletRequest request) {
			

			System.out.println(" Reached here /addNewProduct");
			String productCategoryName = newProductHolder.getSelectedproduct(); 
			System.out.println(productCategoryName);
			String productSubCategoryName = newProductHolder.getSelectedsubProduct(); 
			System.out.println(productSubCategoryName);
			String toAddProductName = newProductHolder.getToAddProductName(); 
			System.out.println(toAddProductName);
			Integer toAddProductQuantity = newProductHolder.getToAddProductQuantity();
			System.out.println(toAddProductQuantity);
			
			// Get productCategoryId from selectedsubProduct
			 ProductCategory productCategory =   jdbcProductCategoryRepository.getProductCategoryDetailsByName(productCategoryName);
			 System.out.println("ProductCategoryId "+productCategory.getProductCategoryId());
			 
			// Get productSubCategoryId from selectedsubProduct
			 ProductSubCategory productSubCategory = jdbcProductSubCategoryRepository.getProductSubCategoryDetailsByName(productSubCategoryName);
			 System.out.println("productSubCategoryId "+productSubCategory.getProductSubCategoryId());
			 
			// Get productId based on the productCategoryId and productSubCategoryId
			// 1012100,'Audio Speech 1',1012,'Audio Speech',101,'Embedded Electronics'
			 Integer productId = jdbcProductRepository.getNewProductId(productSubCategoryName);
			 System.out.print(productId);
			 
			 Product product = new Product();
			 product.setProductCategoryId(productCategory.getProductCategoryId());
			 product.setProductCategoryName(productCategory.getProductCategoryName());
			 product.setProductSubCategoryId(productSubCategory.getProductSubCategoryId());
			 product.setProductSubCategoryName(productSubCategory.getProductSubCategoryName());
			 product.setProductId(productId);
			 product.setProductName(toAddProductName);
			 product.setProductQuantity(toAddProductQuantity);
			 product.setProductActive(true);
			 product.setSkucode("sku"+productId);
			 
			 jdbcProductRepository.save(product);
					
			return new ResponseEntity<>(newProductHolder, HttpStatus.OK);
			
		}
		
}
