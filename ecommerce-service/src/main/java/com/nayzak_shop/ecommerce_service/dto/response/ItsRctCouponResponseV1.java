package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctCouponResponseV1 {
    private Long id ;
    private String code ;
    private Double discount ;
}
