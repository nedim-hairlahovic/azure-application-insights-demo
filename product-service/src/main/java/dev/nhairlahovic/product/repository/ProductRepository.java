package dev.nhairlahovic.product.repository;

import dev.nhairlahovic.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
