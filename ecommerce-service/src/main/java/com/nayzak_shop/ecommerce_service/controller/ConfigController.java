package com.nayzak_shop.ecommerce_service.controller;

import com.nayzak_shop.ecommerce_service.dto.response.ItsRctConfigResponseV1;
import com.nayzak_shop.ecommerce_service.dto.response.ItsRctCurrencyResponseV1;
import com.nayzak_shop.ecommerce_service.service.ConfigService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping("/v1/config")
@Tag(
        name = "Config",
        description = "Configuration related operations"
)
public class ConfigController {
    @Autowired
    private ConfigService configService ;
    @Operation(
            summary = "get All Configs",
            description = "This api will return all Config"
    )
    @GetMapping
    public List<ItsRctConfigResponseV1>configs() {
        return this.configService.getAllConfigs()
                .stream()
                .map(item -> {
                    ItsRctConfigResponseV1 response = new ItsRctConfigResponseV1();
                    BeanUtils.copyProperties(item, response);
                    return response;
                })
                .collect(Collectors.toList());
    }

}
