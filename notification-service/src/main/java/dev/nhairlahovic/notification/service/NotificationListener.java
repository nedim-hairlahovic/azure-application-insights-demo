package dev.nhairlahovic.notification.service;

import dev.nhairlahovic.notification.model.OrderNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "#{@rabbitMQConfig.getOrderQueue()}")
    public void handleOrderNotification(OrderNotification notification) {
        System.out.println("📩 New order received: " + notification);
    }
}
