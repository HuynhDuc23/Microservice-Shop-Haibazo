package com.nayzak_shop.ecommerce_service.service.impl;

import com.nayzak_shop.ecommerce_service.model.Language;
import com.nayzak_shop.ecommerce_service.repository.LanguageRepository;
import com.nayzak_shop.ecommerce_service.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository ;

    @Override
    public List<Language> getAllLanguages() {
       return this.languageRepository.findAll();
    }
}
