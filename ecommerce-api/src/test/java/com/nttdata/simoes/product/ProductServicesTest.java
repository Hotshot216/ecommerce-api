//package com.nttdata.simoes.product;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.verify;
//
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//
//@ExtendWith(MockitoExtension.class)
//public class ProductServicesTest {
//
//	@Mock	
//	private ProductRepository productRepository;
//	private AutoCloseable autoCloseable;
//	@InjectMocks
//	private ProductServices underTest;
//	
//	
//	@BeforeEach
//	void setUp() {
//		autoCloseable = MockitoAnnotations.openMocks(this);
//		underTest = new ProductServices(productRepository);
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
//				"Test Product"
//				);
//		//when
//		underTest.saveProduct(product);
//		
//		//then
//		verify(productRepository).save(product);
//	}
//	
//	@Test
//	void shouldGetAll() {
//		//when
//		underTest.getAll();
//		//then
//		verify(productRepository).findAll();
//	}
//	
//	@Test
//	void shouldGetCompanyData() {
//		//given
//		
//		//when
//		underTest.getCompanyData();
//		
//		//then
//		assertThat(underTest.getCompanyData())
//					.isEqualTo(String.format("Company: %s\nCountry: %s\nCity: %s", 
//							underTest.getCompanyName(),underTest.getCompanyCountry(),underTest.getCompanyCity()));
//	}
//	
//	@Test
//	void shouldListByCode() {
//		
//		String code = "TEST123";
//		
//		Product product = new Product(
//				code,
//				"Test Product"
//				);
//		
//		productRepository.save(product);
//		
//		//when
//		underTest.listByCode(code);
//		
//		//then
//		verify(productRepository).findByCode(code);
//	}
//	
//	@Test
//	void shouldAddProduct() {
//		//given
//		Product product = new Product(
//				"TEST123",
//				"Test Product"
//				);
//		//when
//		underTest.addProduct(product);
//		
//		//then
//		verify(productRepository).save(product);
//	}
//	
//	@Test @Disabled
//	void shouldUpdateProduct() {
//		//given
//		Product product = new Product(				
//				"TEST123",
//				"Test Product"
//				);
//		
//		underTest.addProduct(product);
//		
//		String newCode = "123TEST";
//		String newName = "Product Test";
//		
//		Product newProduct = new Product(
//				newCode,
//				newName
//				);
//		
//		//when
//		underTest.updateProduct(newProduct, product.getId());
//		
//		//then		
//		assertThat(product.getCode().equals(newProduct.getCode()));
//		assertThat(product.getName().equals(newProduct.getName()));
//	}
//	
//	@Test 
//	void shouldDeleteProduct() {
//		
//		//given
//		Product product = new Product(				
//				"TEST123",
//				"Test Product"
//				);
//		
//		underTest.addProduct(product);
//		
//		//when
//		underTest.deleteProduct(product.getId());
//		
//		//then
//		verify(productRepository).deleteById(product.getId());
//	}
//	
//	@Test @Disabled
//	void shouldNotDeleteProduct() {
//		
//				
//		Product product = new Product(				
//				"TEST123",
//				"Test Product"
//				);
//		
//		underTest.deleteProduct(null);
//		
//	}
//}
