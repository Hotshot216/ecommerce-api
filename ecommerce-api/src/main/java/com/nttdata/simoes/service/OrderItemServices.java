package com.nttdata.simoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.simoes.exception.ResourceNotFoundException;
import com.nttdata.simoes.model.OrderItem;
import com.nttdata.simoes.model.Product;
import com.nttdata.simoes.repository.OrderItemRepository;
import com.nttdata.simoes.repository.ProductRepository;

@Service
public class OrderItemServices {

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	//return price
	public Product productById(OrderItem orderItem) {
		
		Product product = productRepository.findById(orderItem.getProductId()).get();
		
		return product;
		
	}
	
	//ADD ORDERITEM
	public OrderItem addOrderItem(OrderItem orderItem) {
		
		Product product = productById(orderItem);
		
		orderItem.setOrderItemPrice(product.getPrice()*orderItem.getQuantity());
		orderItem.setProductName(product.getName());
		return orderItemRepository.save(orderItem);
	}
	
	//LIST ALL
	public List<OrderItem> listAll(){
		return orderItemRepository.findAll();
	}
	
	//LIST BY CODE
	public Optional<OrderItem> listById(Long id){
		return orderItemRepository.findById(id);
	}
	
	//UPDATE
	public ResponseEntity<OrderItem> updateOrderItem(OrderItem newOrderItem, Long id){
		
		Product product = productById(newOrderItem);
		
		OrderItem updatedOrderItem = orderItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order Item with ID "+ id + " does not exist"));
		
		updatedOrderItem.setOrderItemPrice(newOrderItem.getOrderItemPrice());
		updatedOrderItem.setProductId(newOrderItem.getProductId());
		//updatedOrderItem.setOrder(newOrderItem.getOrder());
		updatedOrderItem.setQuantity(newOrderItem.getQuantity());
		updatedOrderItem.setProductName(product.getName());
		
		orderItemRepository.save(updatedOrderItem);
		
		return ResponseEntity.ok(updatedOrderItem);
	}
	
	//DELETE
	public ResponseEntity<String> deleteOrderItem(Long id) {
		
		try {
			orderItemRepository.deleteById(id);
			
			return new ResponseEntity<>("Order Item deleted with success",HttpStatus.OK);
		}catch(Exception e) {
			return null;
		}		
		
	}
	
}
