//package com.nttdata.simoes.product;
//
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//public class ProductControllerTest {
//
//	@Mock
//	private ProductServices productServices;
//	private AutoCloseable autoCloseable;
//	@InjectMocks
//	private ProductController underTest;
//	
//	@BeforeEach
//	void setUp() {
//		autoCloseable = MockitoAnnotations.openMocks(this);
//		underTest = new ProductController(productServices);
//		
//	}
//	
//	@AfterEach
//	void tearDown() throws Exception {
//		autoCloseable.close();
//	}
//	
//	@Test
//	void shouldSaveProduct() {
//		//given
//		Product product = new Product(
//				"TEST123",
//				"TEST"
//				);
//		
//		//WHEN
//		underTest.saveProduct(product);
//		
//		//then
//		verify(productServices).saveProduct(product);
//	}
//	
//	@Test
//	void shouldList() {
//		//WHEN
//		underTest.list();
//		
//		//then
//		verify(productServices).getAll();
//	}
//	
//	@Test
//	void shouldListCode() {
//		//given
//		String code = "TEST123";
//		
//		Product product = new Product(
//				code,
//				"Test"
//				);
//		
//		underTest.saveProduct(product);
//		
//		//when
//		underTest.listCode(code);
//		
//		//then
//		verify(productServices).listByCode(code);
//	}
//	
//	@Test
//	void shouldCompanyData() {
//		//when
//		underTest.companyData();
//		//then
//		verify(productServices).getCompanyData();
//	}
//	
//	@Test
//	void shouldPostProduct() {
//		//given
//		Product product = new Product(
//				"TEST123",
//				"TEST"
//				);
//		//when
//		underTest.postProduct(product);
//		//then
//		verify(productServices).addProduct(product);
//	}
//	
//	@Test
//	void shouldPutProduct() {
//		//given
//		Product product = new Product(
//				"TEST123",
//				"TEST"
//				);
//		
//		underTest.postProduct(product);
//		
//		Product updatedProduct = new Product(
//				"123TEST",
//				"NEWTEST"
//				);
//		//when
//		underTest.putProduct(updatedProduct, product.getId());
//		//then
//		verify(productServices).updateProduct(updatedProduct, product.getId());
//	}
//	
//	@Test
//	void shouldDeleteProduct() {
//		//given
//		Product product = new Product(
//				"TEST123",
//				"TEST"
//				);
//		
//		underTest.postProduct(product);
//		//when
//		underTest.deleteProduct(product.getId());
//		//then
//		verify(productServices).deleteProduct(product.getId());
//				
//	}
//}
