package dev.nhairlahovic.order.repository;

import dev.nhairlahovic.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
