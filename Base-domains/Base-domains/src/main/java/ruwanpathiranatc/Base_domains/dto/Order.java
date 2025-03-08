package ruwanpathiranatc.Base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderId;
    private String orderName;
    private int qty;
    private double price;

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public int getQty() {
        return qty;
    }




}


