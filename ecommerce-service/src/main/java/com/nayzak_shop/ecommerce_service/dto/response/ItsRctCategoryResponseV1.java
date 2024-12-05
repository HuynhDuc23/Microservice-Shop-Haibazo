package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctCategoryResponseV1 {
    private int id ;
    private String name ;
    private ItsRctCategoryTypeResponseV1 type ;
    private String image ;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
    private LocalDateTime deletedAt ;
}
