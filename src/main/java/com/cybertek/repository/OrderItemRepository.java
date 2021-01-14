package com.cybertek.repository;

import com.cybertek.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {

    Optional<OrderItem> findByOrderId(Long Id);

}