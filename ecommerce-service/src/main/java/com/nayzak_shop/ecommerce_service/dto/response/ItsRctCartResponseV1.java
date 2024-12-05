package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItsRctCartResponseV1 {
    private int number ;
    private ItsRctProductResponseV1 product ;
    private ItsRctProductAvailableVariantResponseV1 productVariant ;
    private int quantity ;
}
