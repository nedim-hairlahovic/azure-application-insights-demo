package dev.nhairlahovic.notification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderNotification {
    private String orderId;
    private String productName;
    private int quantity;
    private double totalPrice;
}
