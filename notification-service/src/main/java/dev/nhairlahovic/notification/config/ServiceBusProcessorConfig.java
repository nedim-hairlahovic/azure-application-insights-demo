package dev.nhairlahovic.notification.config;

import com.azure.messaging.servicebus.ServiceBusReceivedMessage;
import com.azure.spring.cloud.service.servicebus.consumer.ServiceBusErrorHandler;
import com.azure.spring.cloud.service.servicebus.consumer.ServiceBusRecordMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class ServiceBusProcessorConfig {

    @Bean
    ServiceBusRecordMessageListener processMessage() {
        return context -> {
            ServiceBusReceivedMessage message = context.getMessage();
            System.out.println("📩 New order received: " + message.getBody());
        };
    }

    @Bean
     ServiceBusErrorHandler processError() {
        return context -> {
            System.out.printf("Error when receiving messages from namespace: '%s'. Entity: '%s'%n",
                    context.getFullyQualifiedNamespace(), context.getEntityPath());
        };
    }
}
