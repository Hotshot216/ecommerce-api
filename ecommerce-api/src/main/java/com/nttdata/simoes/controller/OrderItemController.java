package com.nttdata.simoes.controller;

import java.util.List;
import java.util.Optional;

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

import com.nttdata.simoes.model.OrderItem;
import com.nttdata.simoes.service.OrderItemServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/OrderItem")
public class OrderItemController {

	@Autowired
	private OrderItemServices orderItemServices;
	
	//GET
	@GetMapping("/all")
	public List<OrderItem> getAll(){
		return orderItemServices.listAll();
	}
	
	//GET ID
	@GetMapping("/id/{id}")
	public Optional<OrderItem> getById(@PathVariable Long id){
		return orderItemServices.listById(id);
	}
	
	//ADD
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public OrderItem postOrderItem(@Valid @RequestBody OrderItem orderItem) {
		return orderItemServices.addOrderItem(orderItem);
	}
	
	//PUT CLIENT
	@PutMapping("/update/id/{id}")
	public ResponseEntity<OrderItem> putProducy(@Valid @RequestBody OrderItem newOrderItem, @PathVariable Long id){
		return orderItemServices.updateOrderItem(newOrderItem, id);
	}
	
	//DELETE CLIENT
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String>deleteOrderItem(@PathVariable Long id){
		return orderItemServices.deleteOrderItem(id);
	}

}
