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
public class ItsRctProductAvailableVariantResponseV1 {
    private List<ItsRctProductVariantResponseV1> variants ;
    private double price ;
    private double discountPrice ;
    private int stock ;
    private String image ;
}
