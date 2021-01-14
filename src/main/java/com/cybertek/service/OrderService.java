package com.cybertek.service;

import com.cybertek.model.Order;
import com.cybertek.repository.OrderRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(Order order){

        //TODO How can I check order is Exist or Not

        return null;
    }

    public void update(Order order){

        //TODO How can I check order is Exist or Not

    }
    public Order readById(Order order){

        return orderRepository.findById(order.getId()).orElse(null);

    }
    public List<Order> readAll(){

        return orderRepository.findAll(Sort.by("orderDate")); // maybe user_id but not necessary I think

    }


}
