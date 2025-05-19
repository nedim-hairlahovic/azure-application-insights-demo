package dev.nhairlahovic.order.service;

import dev.nhairlahovic.order.client.ProductClient;
import dev.nhairlahovic.order.model.Order;
import dev.nhairlahovic.order.model.OrderRequest;
import dev.nhairlahovic.order.model.Product;
import dev.nhairlahovic.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public Order processOrder(OrderRequest orderRequest) {
        Product product = productClient.getProductById(orderRequest.getProductId());
        double totalPrice = product.getPrice() * orderRequest.getQuantity();

        Order newOrder = new Order(null, product, orderRequest.quantity, totalPrice);
        Order savedOrder = orderRepository.save(newOrder);

        notificationService.sendOrderCreatedNotification(savedOrder, product);

        return savedOrder;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
