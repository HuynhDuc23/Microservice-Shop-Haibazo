package com.nayzak_shop.ecommerce_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "variant_groups")
public class VariantGroup extends BaseEntity{

    @Id
    @Column(name = "variant_groups_key", nullable = false, unique = true)
    private String variantKey;

    @Column(name = "name", nullable = false)
    private String name;
}
