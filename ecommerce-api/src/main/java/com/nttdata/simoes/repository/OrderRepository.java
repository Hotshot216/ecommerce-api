package com.nttdata.simoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.simoes.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
