package com.nayzak_shop.ecommerce_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctGetProductQueryV1 {
      private List<Number> variantIds ;
      private Double priceMin ;
      private Double priceMax ;
      private List<Number> categoryIds ;
      private String sortBy ;
      private String orderBy ;
      private String search ;
}
