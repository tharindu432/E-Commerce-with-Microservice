package ruwanpathiranatc.Email.Service.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ruwanpathiranatc.Base_domains.dto.OrderEvent;

@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent event) {
        // Logging the received event
        LOGGER.info("Order event received in Email Service: {}", event);

        // Directly print to console for debugging
        System.out.println("************** Order Event Received **************");
        System.out.println("Event Details: " + event);
        System.out.println("**************************************************");

        //Send an email to the customer (Implementation needed)
    }
}
