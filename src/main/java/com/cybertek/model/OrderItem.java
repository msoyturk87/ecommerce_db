package com.cybertek.model;

import com.cybertek.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "order_items")
public class OrderItem extends BaseEntity<Long>{


    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;



}
