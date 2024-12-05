package com.nayzak_shop.ecommerce_service.service.impl;

import com.nayzak_shop.ecommerce_service.dto.response.ItsRctLanguageResponseV1;
import com.nayzak_shop.ecommerce_service.model.Currency;
import com.nayzak_shop.ecommerce_service.repository.CurrencyRepository;
import com.nayzak_shop.ecommerce_service.service.CurrencyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository ;
    @Override
    public List<Currency> getAllCurrency() {
       return this.currencyRepository.findAll();
    }
}
