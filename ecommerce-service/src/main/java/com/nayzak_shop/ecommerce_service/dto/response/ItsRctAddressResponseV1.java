package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItsRctAddressResponseV1 {
    private long id ;
    private String displayName ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private String phone ;
    private String streetAddress ;
    private ItsRctCountryResponseV1 country ;
    private ItsRctCityResponseV1 city ;
    private ItsRctDistrictResponseV1 district ;
    private ItsRctWardResponseV1 ward ;
    private String zipCode ;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
    private LocalDateTime deletedAt ;
}
