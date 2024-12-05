package com.nayzak_shop.ecommerce_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "configs")
public class Config extends BaseEntity{

    @Id
    @Column(name = "key" , nullable = false)
    private String key;
    @Lob
    @Column(name = "value", nullable = false)
    private String value;

}
