package com.cqrs.order.events;

public class OrderCreatedEvent {
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    private int orderId;

    public OrderCreatedEvent(int orderId) {
        this.orderId = orderId;
    }
}
