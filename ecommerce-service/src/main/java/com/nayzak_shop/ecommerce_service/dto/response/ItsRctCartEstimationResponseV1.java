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
public class ItsRctCartEstimationResponseV1 {
    private double total ;
    private double totalQuantity ;
    private List<ItsRctCartResponseV1> carts ;
    private ItsRctCouponResponseV1 coupon ;
}
