package com.electronics.products;

import java.sql.Timestamp;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ElectronicStoreApplication implements WebMvcConfigurer{
	
	public static void main(String args[]) {
			
			SpringApplication.run(ElectronicStoreApplication.class, args);    
			       
			Timestamp timestamp = new Timestamp(Calendar.getInstance().getTimeInMillis());
			// Timestamp timestamp = new Timestamp(new Date().getTime()); 
			             
			System.out.println(timestamp);                        
		}        
}   
