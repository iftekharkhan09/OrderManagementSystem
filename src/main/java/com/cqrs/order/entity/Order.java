package com.cqrs.order.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    private Integer id;

    public Order(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Order(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    @OneToMany
    private List<Product> products;

    @Override
    public String toString() {
        return "name is"+name;
    }
}
