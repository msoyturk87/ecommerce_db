package com.cybertek.service;

import com.cybertek.enums.OrderStatus;
import com.cybertek.model.Order;
import com.cybertek.model.OrderItem;
import com.cybertek.repository.OrderItemRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderService orderService;


    public OrderItemService(OrderItemRepository orderItemRepository, OrderService orderService) {
        this.orderItemRepository = orderItemRepository;
        this.orderService = orderService;
    }


    public OrderItem create(OrderItem orderItem) throws Exception {


        List<Order> orders = orderService.readByUserAndStatus(orderItem.getOrder().getUser(), OrderStatus.IN_PROGRESS);

        if(orders.size()>0){
            Order currentOrder=orders.get(0);
            orderItem.setOrder(currentOrder); // cascade will know that
        }

        /*Optional<OrderItem> foundedOrderItem=orderItemRepository.findById(orderItem.getId());

        if(foundedOrderItem.isPresent()){

            throw new Exception("This order item already exists");
        }*/

        return null;
    }

    public void update(OrderItem orderItem){

        // TODO We should talk about this part to take data from db (unique)

    }

    public OrderItem readById(Long id) throws Exception {

        return orderItemRepository.findById(id).orElseThrow(()->new Exception("No orderItem "));
    }

    public List<OrderItem> readAll(){

        return orderItemRepository.findAll(Sort.by("orderStatus"));
    }






}
