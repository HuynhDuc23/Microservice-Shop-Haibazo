package com.nayzak_shop.ecommerce_service.controller;


import com.nayzak_shop.ecommerce_service.dto.response.ItsRctLanguageResponseV1;
import com.nayzak_shop.ecommerce_service.model.Language;
import com.nayzak_shop.ecommerce_service.service.LanguageService;
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
@RequestMapping("/v1/languages")
@Tag(name = "LanguageController")
public class LanguageController {
    @Autowired
    private LanguageService languageService ;
    @GetMapping
    @Operation(
            summary = "Get all languages",
            description = "This API will return all languages."
    )
    public List<ItsRctLanguageResponseV1> languages() {
        return this.languageService.getAllLanguages()
                .stream()
                .map(item -> {
                    ItsRctLanguageResponseV1 response = new ItsRctLanguageResponseV1();
                    BeanUtils.copyProperties(item, response);
                    return response;
                })
                .collect(Collectors.toList());
    }
}
