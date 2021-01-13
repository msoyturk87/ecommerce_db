package com.cybertek.repository;

import com.cybertek.enums.Status;
import com.cybertek.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

   List<Product> findAllByStatus(Status status);
}
