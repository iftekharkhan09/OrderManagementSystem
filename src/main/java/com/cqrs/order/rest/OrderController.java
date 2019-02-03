package com.cqrs.order.rest;

import com.cqrs.order.commands.CreateOrderCommand;
import com.cqrs.order.domain.OrderQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class OrderController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    public OrderController(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @PostMapping("/confirmOrder")
    public void shipOrder() {
        commandGateway.send(new CreateOrderCommand(1));
    }

   @GetMapping("/orders")
   public CompletableFuture<String> findOrderById(@RequestParam("id") int id) {
       return queryGateway.query(new OrderQuery(id),String.class);
   }
}
