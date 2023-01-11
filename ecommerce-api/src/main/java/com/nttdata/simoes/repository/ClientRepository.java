package com.nttdata.simoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.simoes.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
