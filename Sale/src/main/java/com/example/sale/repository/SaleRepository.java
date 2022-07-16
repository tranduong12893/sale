package com.example.sale.repository;

import com.example.sale.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Product, String> {
}
