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

import com.nttdata.simoes.model.Client;
import com.nttdata.simoes.service.ClientServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientServices clientServices;
	
	//GET
	@GetMapping("/all")
	public List<Client> getAllClients() {
		return clientServices.getAll();
	}
	
	//GET ID
	@GetMapping("/id/{id}")
	public Optional<Client> getById(@PathVariable Long id){
		return clientServices.listById(id);
	}
	
	//POST CLIENT
	@PostMapping("/add")
	public Client postClient(@Valid @RequestBody Client client) {
		return clientServices.addClient(client);
	}
	
	//PUT CLIENT
	@PutMapping("/update/id/{id}")
	public ResponseEntity<Client> putProducy(@Valid @RequestBody Client newClient, @PathVariable Long id){
		return clientServices.updateClient(newClient, id);
	}
	
	//DELETE CLIENT
	@DeleteMapping("/delete/id/{id}")
	public ResponseEntity<String>deleteClient(@PathVariable Long id){
		return clientServices.deleteClient(id);
	}

}
