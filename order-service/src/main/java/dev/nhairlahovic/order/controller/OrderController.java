package dev.nhairlahovic.order.controller;

import dev.nhairlahovic.order.model.Order;
import dev.nhairlahovic.order.model.OrderRequest;
import dev.nhairlahovic.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order submitOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.processOrder(orderRequest);
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}
