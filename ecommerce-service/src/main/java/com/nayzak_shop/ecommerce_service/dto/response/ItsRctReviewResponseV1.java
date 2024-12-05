package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItsRctReviewResponseV1 {
    private ItsRctUserResponseV1 user ;
    private List<String> images ;
    private double rating ;
    private String review ;
}
