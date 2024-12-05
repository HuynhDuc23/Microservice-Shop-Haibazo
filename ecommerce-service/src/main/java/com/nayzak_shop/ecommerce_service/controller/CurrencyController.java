package com.nayzak_shop.ecommerce_service.controller;
import com.nayzak_shop.ecommerce_service.dto.response.ItsRctCurrencyResponseV1;
import com.nayzak_shop.ecommerce_service.service.CurrencyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/currency")
@Tag(name="CurrencyController")
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService ;
    @Operation(
            summary = "Get all currencies",
            description = "This API will return all currencies."
    )
    @GetMapping
    public List<ItsRctCurrencyResponseV1> currencies() {
        return this.currencyService.getAllCurrency()
                .stream()
                .map(item -> {
                    ItsRctCurrencyResponseV1 response = new ItsRctCurrencyResponseV1();
                    BeanUtils.copyProperties(item, response);
                    return response;
                })
                .collect(Collectors.toList());
    }
}
