package com.rincon.taco_cloud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rincon.taco_cloud.Models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}

