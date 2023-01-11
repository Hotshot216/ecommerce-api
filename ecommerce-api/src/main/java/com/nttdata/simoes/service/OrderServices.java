package com.nttdata.simoes.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.simoes.exception.ResourceNotFoundException;
import com.nttdata.simoes.model.Order;
import com.nttdata.simoes.model.OrderItem;
import com.nttdata.simoes.repository.OrderRepository;

@Service
public class OrderServices {
	

	@Autowired
	private OrderRepository orderRepository;
		
	//return price
	public float getSumOrder(Order order) {
	    float sum = 0f;
	    for(OrderItem oi : order.getOrderItemList()) {
	        sum += oi.getOrderItemPrice();
	    }
	    return sum;
	}
		
	//ADD ORDER
	public Order addOrder(Order order) {
		
		order.setInitialDate(LocalDate.now());
		order.setOrderPrice(getSumOrder(order));
		
		return orderRepository.save(order);
	}
	
	//LIST ALL
	public List<Order> listAll(){
		return orderRepository.findAll();
	}
	
	//LIST BY CODE
	public Optional<Order> listById(Long id){
		return orderRepository.findById(id);
	}
	
	//UPDATE
	public ResponseEntity<Order> updateOrder(Order newOrder, Long id){
		
		
		Order updatedOrder = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with ID "+ id + " does not exist"));
		
		updatedOrder.setOrderPrice(newOrder.getOrderPrice());
		updatedOrder.setClient(newOrder.getClient());
		updatedOrder.setDeliveryDate(newOrder.getDeliveryDate());
		updatedOrder.setInitialDate(newOrder.getInitialDate());
		
		orderRepository.save(updatedOrder);
		
		return ResponseEntity.ok(updatedOrder);
	}
	
	//DELETE
	public ResponseEntity<String> deleteOrder(Long id) {
		
		try {
			orderRepository.deleteById(id);
			
			return new ResponseEntity<>("Order deleted with success",HttpStatus.OK);
		}catch(Exception e) {
			return null;
		}		
		
	}



	
}
