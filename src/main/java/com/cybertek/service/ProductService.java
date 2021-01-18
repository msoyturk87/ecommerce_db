package com.cybertek.service;

import com.cybertek.enums.Status;
import com.cybertek.model.*;
import com.cybertek.repository.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product){

        return productRepository.save(product);
    }

    public void update(Product product){

        //productRepository.findById Ok it is good
        // TODO We should talk about this part to take data from db (unique)
    }

    public List<Product> readAllActive(){

        return productRepository.findAllByStatus(Status.ACTIVE);
    }

    public List<Product> readAll(){

        return productRepository.findAll(Sort.by("name"));
    }
    public Product readById(Long id){

        return productRepository.findById(id).orElse(null);
    }

    public List<Product> readAllBySubCategory(SubCategory subCategory){

        return productRepository.findAllBySubCategoryId(subCategory.getId());
    }


    public List<Product> readAllByUom(Uom foundedUom) {
        return productRepository.findByUom(foundedUom);
    }

    public List<Product> readAllByCurrency(Currency foundedCurrency) {

        return productRepository.findByCurrency(foundedCurrency);
    }
}
