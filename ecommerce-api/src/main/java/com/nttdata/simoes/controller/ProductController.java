package com.nttdata.simoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.simoes.model.Product;
import com.nttdata.simoes.service.ProductServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	private ProductServices productServices;
//	private final ProductServices productServices;
//	
//	public ProductController(ProductServices productServices) {
//		this.productServices = productServices;
//	}
	
	public Product saveProduct(Product prod) {
		return productServices.saveProduct(prod);
	}
	
	//GET ALL PRODUCTS
	@GetMapping
	public List<Product> list(){				
		return productServices.getAll();
	}
	
	//GET SPECIFIC PRODUCT BY CODE
	@GetMapping("/{code}")
	public List<Product> listCode(@PathVariable String code){
		return productServices.listByCode(code);
	}
	
	//GET COMPANY INFORMATION
	@GetMapping("/company-data")
	public String companyData() {
		return productServices.getCompanyData();
	}
	
	//POST NEW PRODUCT
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Product postProduct(@Valid @RequestBody Product product) {		
		return productServices.addProduct(product);
	}
	
	//UPDATE PRODUCT
	@PutMapping("/update/id/{id}")
	public ResponseEntity<Product> putProduct(@Valid @RequestBody Product newProduct, @PathVariable Long id) {
		return productServices.updateProduct(newProduct,id);
	}
	
	//DELETE PRODUCT
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String> deleteProduct(@Valid @PathVariable Long id){
		return productServices.deleteProduct(id);
	}
}
