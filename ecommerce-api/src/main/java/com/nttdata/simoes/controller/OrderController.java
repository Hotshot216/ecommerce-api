package com.nttdata.simoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.simoes.model.Order;
import com.nttdata.simoes.service.OrderServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Orders/")
public class OrderController {

	@Autowired
	private OrderServices orderServices;
	
	//GET
	@GetMapping("/all")
	public List<Order> getAllOrders() {
		return orderServices.listAll();
	}
	
	//GET ID
	@GetMapping("/id/{id}")
	public Optional<Order> getById(@PathVariable Long id){
		return orderServices.listById(id);
	}
	
	//POST CLIENT
	@PostMapping("/add")
	public Order postOrder(@Valid @RequestBody Order order) {
		return orderServices.addOrder(order);
	}
	
	//PUT CLIENT
	@PutMapping("/update/id/{id}")
	public ResponseEntity<Order> putProducy(@Valid @RequestBody Order newOrder, @PathVariable Long id){
		return orderServices.updateOrder(newOrder, id);
	}
	
	//DELETE CLIENT
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String>deleteOrder(@PathVariable Long id){
		return orderServices.deleteOrder(id);
	}


}
