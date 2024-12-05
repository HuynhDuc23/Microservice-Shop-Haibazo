package com.nayzak_shop.ecommerce_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItsRctPostResponseV1 {
    private long id ;
    private String title ;
    private ItsRctUserResponseV1 user ;
    private int viewCount ;
    private int commentCount ;
    private List<String> tags ;
    private String content ;
    private String image ;
    private LocalDateTime createdAt ;
}
