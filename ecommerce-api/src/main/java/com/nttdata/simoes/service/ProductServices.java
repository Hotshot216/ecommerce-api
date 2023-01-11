package com.nttdata.simoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.simoes.exception.ResourceNotFoundException;
import com.nttdata.simoes.model.Product;
import com.nttdata.simoes.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
//	private final ProductRepository productRepository;
//	
//	public ProductServices(ProductRepository productRepository) {
//		this.productRepository = productRepository;
//	}
	
	@Value(value="${app.company.name}")
	private String companyName;
	@Value(value="${app.company.address.country}")
	private String companyCountry;
	@Value(value="${app.company.address.city}")
	private String companyCity;
	
	//SAVE PRODUCT
	public Product saveProduct(Product prod) {
		return productRepository.save(prod);
	}
	
		
	//GET COMPANY DATA
	public String getCompanyData() {
		
	return String.format("Company: %s\nCountry: %s\nCity: %s", companyName,companyCountry,companyCity);
		
	}
	//GET ALL
	public List<Product> getAll(){
		
		return productRepository.findAll();
	}
	
	//LIST BY CODE
	public List<Product> listByCode(String code){
		return productRepository.findByCode(code);
	}
	
	//ADD PRODUCT
	public Product addProduct(Product product) {				
		return productRepository.save(product);			 
	}
	
	//UPDATE
	public ResponseEntity<Product> updateProduct(Product newProduct, Long id) {
		
		Product updateProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with ID "+ id + " does not exist"));
		
		updateProduct.setCode(newProduct.getCode());
		updateProduct.setName(newProduct.getName());
		
		productRepository.save(updateProduct);
		
		return ResponseEntity.ok(updateProduct);
	}
	
	//DELETE
	public ResponseEntity<String> deleteProduct(Long id) {
		
		try {
			productRepository.deleteById(id);
			
			return new ResponseEntity<>("Product deleted with success",HttpStatus.OK);
		}catch(Exception e) {
			return null;
		}
		
		
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getCompanyCountry() {
		return companyCountry;
	}


	public void setCompanyCountry(String companyCountry) {
		this.companyCountry = companyCountry;
	}


	public String getCompanyCity() {
		return companyCity;
	}


	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}

}
