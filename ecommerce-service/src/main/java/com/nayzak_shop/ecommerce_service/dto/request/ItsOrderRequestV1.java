package com.nayzak_shop.ecommerce_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsOrderRequestV1 {
    private String firstName ;
    private String lastName ;
    private String email ;
    private String phone ;
    private String streetAddress ;
    private Long countryId ;
    private Long cityId ;
    private String state ;
    private String zipCode ;
    private Long shippingMethodId ;
    private Long paymentMethodId ;

}
