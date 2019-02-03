package com.cqrs.order.repository;

import com.cqrs.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepositoryData extends JpaRepository<Order,Integer> {
    Order findById(int id);
}
