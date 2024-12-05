package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctProductVariantResponseV1 {
    private Long id ;
    private ItsRctProductVariantGroupResponseV1 group;
}
