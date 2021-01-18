package com.cybertek.service;

import com.cybertek.model.OrderItem;
import com.cybertek.repository.OrderItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }





    public OrderItem create(OrderItem orderItem){


        /*Optional<OrderItem> foundedOrderItem = orderItemRepository.findByOrderId(orderItem.getOrder().getId());

        if(foundedOrderItem.isPresent()){
            throw new Exception("This orderItem is already exist ");
        }
        return orderItemRepository.save(orderItem);*/
        // TODO We should talk about this part to take data from db (unique)

        return null;
    }

    public void update(OrderItem orderItem){

        // TODO We should talk about this part to take data from db (unique)

    }

    public OrderItem readById(Long id){

        return orderItemRepository.findById(id).orElse(null);
    }

    public List<OrderItem> readAll(){

        return orderItemRepository.findAll(Sort.by("orderStatus"));
    }






}
