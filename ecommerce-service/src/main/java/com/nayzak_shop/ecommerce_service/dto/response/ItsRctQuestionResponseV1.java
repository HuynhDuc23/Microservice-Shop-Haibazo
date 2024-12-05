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
public class ItsRctQuestionResponseV1 {
    private long id ;
    private String content ;
    private List<String> images ;
    private ItsRctAnswerResponseV1 answers ;
    private ItsRctUserResponseV1 user ;
}
