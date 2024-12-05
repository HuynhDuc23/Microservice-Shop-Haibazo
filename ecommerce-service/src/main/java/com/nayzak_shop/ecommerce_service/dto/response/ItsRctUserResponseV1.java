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
public class ItsRctUserResponseV1 {
    private long id ;
    private String name ;
    private String haibazoAuthAlias ;
    private String role ;
    private String status ;
    private LocalDateTime createdAt ;
    private LocalDateTime updatedAt ;
    private LocalDateTime deletedAt ;
}
