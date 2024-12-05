package com.nayzak_shop.ecommerce_service.controller;

import com.nayzak_shop.ecommerce_service.dto.response.ItsRctConfigResponseV1;
import com.nayzak_shop.ecommerce_service.dto.response.ItsRctContactResponseV1;
import com.nayzak_shop.ecommerce_service.dto.response.ItsRctCountryResponseV1;
import com.nayzak_shop.ecommerce_service.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/country")
public class CountryController {
    @Autowired
    private CountryService countryService ;
    @GetMapping
    public List<ItsRctCountryResponseV1> countries() {
        return this.countryService.getAllContry()
                .stream()
                .map(item -> {
                    ItsRctCountryResponseV1 response = new ItsRctCountryResponseV1();
                    BeanUtils.copyProperties(item, response);
                    return response;
                })
                .collect(Collectors.toList());
    }
}
