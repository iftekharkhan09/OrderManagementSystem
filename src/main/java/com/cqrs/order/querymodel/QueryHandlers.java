package com.cqrs.order.querymodel;

import com.cqrs.order.domain.OrderQuery;
import com.cqrs.order.entity.Order;
import com.cqrs.order.repository.OrderRepositoryData;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class QueryHandlers {
    private OrderRepositoryData orderRepositoryData;

    public QueryHandlers(OrderRepositoryData orderRepository) {
        this.orderRepositoryData = orderRepository;
    }


    @QueryHandler
   public String fetch(OrderQuery orderQuery){
        System.out.println("I was called!!");
        System.out.println("Id is--"+orderQuery.getId());
       return orderRepositoryData.findById(orderQuery.getId()).getName();
   }
}
