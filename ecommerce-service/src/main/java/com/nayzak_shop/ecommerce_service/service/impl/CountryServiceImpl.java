package com.nayzak_shop.ecommerce_service.service.impl;

import com.nayzak_shop.ecommerce_service.model.Country;
import com.nayzak_shop.ecommerce_service.repository.CountryRepository;
import com.nayzak_shop.ecommerce_service.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository ;
    @Override
    public List<Country> getAllContry() {
        return this.countryRepository.findAll();
    }
}
