package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctProductResponseV1 {
    private long id ;
    private String highlightedImage ;
    private List<String> images ;
    private double rating ;
    private long reviewCount ;
    private long viewCount ;
    private String name ;
    private String shortDescription ;
    private String description ;
    private List<ItsRctProductAvailableVariantResponseV1> availableVariants ;
}
