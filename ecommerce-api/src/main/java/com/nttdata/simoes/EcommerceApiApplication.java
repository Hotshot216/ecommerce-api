package com.nttdata.simoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.simoes.model.Product;

@SpringBootApplication
public class EcommerceApiApplication {
	
	Product[] productArray = new Product[10];		

	public static void main(String[] args) {
				
		SpringApplication.run(EcommerceApiApplication.class, args);
	}	
	
	
	
//	@Bean	
//	public CommandLineRunner ecommerceDemo(ProductRepository productRepository) {
//        return (args) -> {
//        	
//        productArray[0] = new Product("HOME111","Bed");
//		productArray[1] = new Product("HOME222","Table");
//		productArray[2] = new Product("TECH111","Laptop");
//		productArray[3] = new Product("TECH222","Keyboard");
//		productArray[4] = new Product("HOME333","Lamp");
//		productArray[5] = new Product("GAME111","Chessboard");
//		productArray[6] = new Product("TECH333","Headphones");
//		productArray[7] = new Product("OUT111","Skateboard");
//		productArray[8] = new Product("HOME444","Mug");
//		productArray[9]= new Product("OFFICE111","Pen");
//			
//    	
//    	for (int i=0;i<productArray.length;i++) {
//    		productRepository.save(productArray[i]);
//    	}
//        	
//        	        	
//        };
//	}
//	
	
	
}
