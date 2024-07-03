package com.rincon.taco_cloud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rincon.taco_cloud.Models.LineOrder;

public interface LineOrderRepository extends JpaRepository<LineOrder, Integer> {
}
