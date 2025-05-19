package dev.nhairlahovic.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
public class RabbitMQProperties {
    private String exchange;
    private String routingKey;
    private String queue;
}
