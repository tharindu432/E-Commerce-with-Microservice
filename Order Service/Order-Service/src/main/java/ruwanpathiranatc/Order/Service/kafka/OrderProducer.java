package ruwanpathiranatc.Order.Service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ruwanpathiranatc.Base_domains.dto.OrderEvent;

@Service
public class OrderProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
    private NewTopic topic;
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;



    public OrderProducer(NewTopic topic, KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void sendMessage(OrderEvent event) {
        if (event == null) {
            LOGGER.warn("Received null OrderEvent. Skipping message send.");
            return;
        }

        LOGGER.info("Sending Order event: {}", event);

        Message<OrderEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic.name())
.build();

            kafkaTemplate.send(message);

    }

}


