package com.electronics.products.security;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//  The seucrity version used is https://docs.spring.io/spring-security/site/docs/5.3.9.RELEASE/reference/html5/
@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{
	
		
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	
	@Override 
	public void configure(WebSecurity web) throws Exception {
	  
	  web.ignoring().antMatchers("/h2-console/**");
	  
	 }
	 
	
	 @Override 
	   protected void configure(HttpSecurity http) throws Exception {
		  
		   http.csrf().disable()  // avoid 403 error
		   .authorizeRequests()		
		   .antMatchers(HttpMethod.GET,"/listProductsByCategory").permitAll()  // any one access this
		   .antMatchers(HttpMethod.GET,"/findProductSubCategoriesByProductCategoryName").permitAll()  // any one access this
		   .antMatchers(HttpMethod.POST,"/findAllProducts").hasRole("USER")
		   .antMatchers(HttpMethod.POST,"/addProductCategory").hasRole("ADMIN")  // only admin can access this
		   .anyRequest().authenticated().and().httpBasic()
		   .and()
		   .cors();  // enable cors 5.3.19
	
		  
		  } 
	 
	
   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   
	   auth.inMemoryAuthentication()
	   .withUser("buzz")
	   .password(passwordEncoder().encode("buzz"))
	   .authorities("ROLE_USER")
	   .and()
	   .withUser("dumm")
	   .password(passwordEncoder().encode("dumm"))
	   .authorities("ROLE_ADMIN")
	   ;
	    
   }
	 
		 
}
