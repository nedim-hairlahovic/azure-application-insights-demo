package dev.nhairlahovic.product.service;

import dev.nhairlahovic.product.model.Product;
import dev.nhairlahovic.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID=" + id + " not found"));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
