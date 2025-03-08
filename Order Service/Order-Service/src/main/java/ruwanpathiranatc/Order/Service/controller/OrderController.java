package ruwanpathiranatc.Order.Service.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ruwanpathiranatc.Base_domains.dto.Order;
import ruwanpathiranatc.Base_domains.dto.OrderEvent;
import ruwanpathiranatc.Order.Service.kafka.OrderProducer;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody  Order order){
        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in PENDING status");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "order placed successfully...";

    }
}
