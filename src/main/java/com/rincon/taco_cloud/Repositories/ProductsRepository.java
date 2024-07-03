package com.rincon.taco_cloud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rincon.taco_cloud.Models.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}