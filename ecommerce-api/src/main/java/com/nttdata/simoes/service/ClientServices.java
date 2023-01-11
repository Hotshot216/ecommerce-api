package com.nttdata.simoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.simoes.exception.ResourceNotFoundException;
import com.nttdata.simoes.model.Client;
import com.nttdata.simoes.repository.ClientRepository;

@Service
public class ClientServices {
	
	@Autowired
	private ClientRepository clientRepository;
	
	//FOR TESTING PURPOSES/////////////////////////////////////
//	private final ClientRepository clientRepository;
//	
//	public ClientServices(ClientRepository clientRepository) {
//		this.clientRepository = clientRepository;
//	}
	///////////////////////////////////////////////////////////
	
	//ADD CLIENT
	public Client addClient(Client client) {
		return clientRepository.save(client);
	}
	
	//GET ALL CLIENTS
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	
	//LIST BY CODE
	public Optional<Client> listById(Long id){
		return clientRepository.findById(id);
	}
	
	//UPDATE
	public ResponseEntity<Client> updateClient(Client newClient, Long id){
		Client updatedClient = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client with ID "+ id + " does not exist"));
		
		updatedClient.setFirstName(newClient.getFirstName());
		updatedClient.setLastName(newClient.getLastName());
		updatedClient.setAddress(newClient.getAddress());
		updatedClient.setEmail(newClient.getEmail());
		updatedClient.setNif(newClient.getNif());
		
		clientRepository.save(updatedClient);
		
		return ResponseEntity.ok(updatedClient);
	}
	
	//DELETE
	public ResponseEntity<String> deleteClient(Long id) {
		
		try {
			clientRepository.deleteById(id);
			
			return new ResponseEntity<>("Client deleted with success",HttpStatus.OK);
		}catch(Exception e) {
			return null;
		}		
		
	}

}
