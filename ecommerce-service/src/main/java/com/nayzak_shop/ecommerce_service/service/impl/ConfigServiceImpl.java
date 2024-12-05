package com.nayzak_shop.ecommerce_service.service.impl;

import com.nayzak_shop.ecommerce_service.model.Config;
import com.nayzak_shop.ecommerce_service.repository.ConfigRepository;
import com.nayzak_shop.ecommerce_service.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigRepository configRepository ;
    @Override
    public List<Config> getAllConfigs() {
       return this.configRepository.findAll();
    }
}
