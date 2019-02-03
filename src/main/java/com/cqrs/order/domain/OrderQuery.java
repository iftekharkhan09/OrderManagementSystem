package com.cqrs.order.domain;

public class OrderQuery {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;


    public OrderQuery(int id) {
        this.id = id;
    }
}
