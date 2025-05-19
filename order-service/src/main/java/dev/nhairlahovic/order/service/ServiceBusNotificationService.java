package dev.nhairlahovic.order.service;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.nhairlahovic.order.model.Order;
import dev.nhairlahovic.order.model.OrderNotification;
import dev.nhairlahovic.order.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceBusNotificationService implements NotificationService {

    private final ServiceBusSenderClient senderClient;

    @Override
    @SneakyThrows
    public void sendOrderCreatedNotification(Order order, Product product) {
        var notification = new OrderNotification();
        notification.setOrderId(order.getId());
        notification.setProductName(product.getName());
        notification.setQuantity(order.getQuantity());
        notification.setTotalPrice(order.getTotalPrice());

        // Serialize notification object to JSON string
        String messageBody = new ObjectMapper().writeValueAsString(notification);
        var message = new ServiceBusMessage(messageBody);

        // Send the message to the Azure Service Bus queue/topic
        senderClient.sendMessage(message);

        System.out.println("Sent order notification message: " + messageBody);

    }
}
