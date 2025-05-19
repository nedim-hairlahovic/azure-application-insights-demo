package dev.nhairlahovic.order.service;

import dev.nhairlahovic.order.model.Order;
import dev.nhairlahovic.order.model.Product;

public interface NotificationService {

    void sendOrderCreatedNotification(Order order, Product product);

}
