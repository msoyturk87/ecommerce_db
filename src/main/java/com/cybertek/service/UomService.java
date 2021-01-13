package com.cybertek.service;

import com.cybertek.model.Category;
import com.cybertek.model.SubCategory;
import com.cybertek.model.Uom;
import com.cybertek.repository.UomRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UomService {

    private final UomRepository uomRepository;

    public UomService(UomRepository uomRepository) {
        this.uomRepository = uomRepository;
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
        //TODO Add new statement for is there any link with product

        foundedUom.setName(foundedUom.getName()+"-"+foundedUom.getId());
        foundedUom.setIsDeleted(true);
        uomRepository.save(foundedUom);
    }
}
