package com.cybertek.service;

import com.cybertek.model.Currency;
import com.cybertek.model.Product;
import com.cybertek.repository.CurrencyRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final ProductService productService;

    public CurrencyService(CurrencyRepository currencyRepository, ProductService productService) {
        this.currencyRepository = currencyRepository;
        this.productService = productService;
    }


    public Currency create(Currency currency) throws Exception {

        Optional<Currency> foundedCurrency = currencyRepository.findByName(currency.getName());  // 1- findByName

        if(foundedCurrency.isPresent()) {
            throw new Exception(currency.getName()+" already exist.You can not create! "); // 2-  best practice ?
        }
        return currencyRepository.save(currency); // 3- ask this part about return part
    }

    public void update(Currency currency) throws Exception {

        Optional<Currency> foundedCurrency = currencyRepository.findByName(currency.getName());
        if(foundedCurrency.isEmpty())
            throw new Exception(currency.getName()+"  does not exist ");

        currency.setId(foundedCurrency.get().getId());
        currencyRepository.save(currency);

    }

    public List<Currency> readAll(){
        return currencyRepository.findAll(Sort.by("name"));

    }

    public Currency readById(Integer id){

        return currencyRepository.findById(id).orElse(null);
    }

    public void deleteById(Integer id) throws Exception {


        Currency foundedCurrency = currencyRepository.findById(id).orElseThrow(() -> new Exception("Currency doesn't exist"));

        List<Product> products = productService.readAllByCurrency(foundedCurrency);
        if(products.size()>0){
            throw new Exception("This Currency can not be deleted");
        }

        foundedCurrency.setName(foundedCurrency.getName()+"-"+foundedCurrency.getId());
        foundedCurrency.setIsDeleted(true);
        currencyRepository.save(foundedCurrency);
    }



}