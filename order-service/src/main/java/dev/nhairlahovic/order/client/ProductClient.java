package dev.nhairlahovic.order.client;

import dev.nhairlahovic.order.model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface ProductClient {

    @GetExchange("/api/products")
    List<Product> getProducts();

    @GetExchange("/api/products/{id}")
    Product getProductById(@PathVariable("id") Long id);

}
