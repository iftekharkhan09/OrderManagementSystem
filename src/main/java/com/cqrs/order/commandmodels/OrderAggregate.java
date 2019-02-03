package com.cqrs.order.commandmodels;


import com.cqrs.order.commands.CreateOrderCommand;
import com.cqrs.order.entity.Order;
import com.cqrs.order.events.OrderCreatedEvent;
import com.cqrs.order.repository.OrderRepositoryData;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.stereotype.Component;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class OrderAggregate {
    public OrderAggregate(OrderRepositoryData orderRepositoryData) {
        this.orderRepositoryData = orderRepositoryData;
    }

    @AggregateIdentifier
    private Integer orderId;

    private OrderRepositoryData orderRepositoryData;

    @CommandHandler
    public void handle(CreateOrderCommand command) {
        apply(new OrderCreatedEvent(command.getOrderId()));

    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId=event.getOrderId();
        Order order=new Order("Order New");
        orderRepositoryData.save(order);
    }

    protected OrderAggregate() {
        // Required by Axon to build a default Aggregate prior to Event Sourcing
    }

}
