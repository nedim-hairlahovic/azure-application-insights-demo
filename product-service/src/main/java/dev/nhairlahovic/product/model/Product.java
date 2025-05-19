package dev.nhairlahovic.product.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String description;
    private double price;

    public Product(String name, String category, String description, double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }
}
