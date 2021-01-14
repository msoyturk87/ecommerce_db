package com.cybertek.service;

import com.cybertek.model.Product;
import com.cybertek.model.Uom;
import com.cybertek.repository.UomRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UomService {

    private final UomRepository uomRepository;
    private final ProductService productService;

    public UomService(UomRepository uomRepository, ProductService productService) {
        this.uomRepository = uomRepository;
        this.productService = productService;
    }

    public Uom create(Uom uom) throws Exception {

        Optional<Uom> foundedUom = uomRepository.findByName(uom.getName());

        if(foundedUom.isPresent()) {
            throw new Exception("This Uom already exist.You can not create! ");
        }
        return uomRepository.save(uom);  // ask this part
    }

    public void update(Uom uom) throws Exception {

        Optional<Uom> foundedUom = uomRepository.findByName(uom.getName());

        if(foundedUom.isEmpty()) {
            throw new Exception("This Uom does not exist");
        }
        uom.setId(foundedUom.get().getId());

        uomRepository.save(uom);
    }

    public List<Uom> readAll(){
        return  uomRepository.findAll(Sort.by("name"));

    }

    public Uom readById(Integer id){
        return uomRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) throws Exception {

        Uom foundedUom=uomRepository.findById(id).orElseThrow(()-> new Exception("Uom doesn't exist"));
        List<Product> products = productService.readAllByUom(foundedUom);

        if(products.size()>0) {
            throw new Exception("This Uom can not be deleted");
        }
        foundedUom.setName(foundedUom.getName()+"-"+foundedUom.getId());
        foundedUom.setIsDeleted(true);
        uomRepository.save(foundedUom);
    }
}
