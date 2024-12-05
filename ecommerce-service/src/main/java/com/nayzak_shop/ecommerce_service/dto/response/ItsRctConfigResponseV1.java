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
public class ItsRctConfigResponseV1 {
    private String key ;
    private String value ;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
    private LocalDateTime deletedAt ;

}
