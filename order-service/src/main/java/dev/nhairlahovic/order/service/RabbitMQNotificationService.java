package dev.nhairlahovic.order.service;

import dev.nhairlahovic.order.config.RabbitMQProperties;
import dev.nhairlahovic.order.model.Order;
import dev.nhairlahovic.order.model.OrderNotification;
import dev.nhairlahovic.order.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

//@Service
@RequiredArgsConstructor
public class RabbitMQNotificationService implements NotificationService {

    private final RabbitTemplate rabbitTemplate;
    private final RabbitMQProperties rabbitProps;

    public void sendOrderCreatedNotification(Order order, Product product) {
        var notification = new OrderNotification();
        notification.setOrderId(order.getId());
        notification.setProductName(product.getName());
        notification.setQuantity(order.getQuantity());
        notification.setTotalPrice(order.getTotalPrice());

        rabbitTemplate.convertAndSend(rabbitProps.getExchange(), rabbitProps.getRoutingKey(), notification);
    }
}
