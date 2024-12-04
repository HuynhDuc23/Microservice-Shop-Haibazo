package com.nayzak_shop.ecommerce_service.model;

import com.nayzak_shop.ecommerce_service.enums.Categories;
import com.nayzak_shop.ecommerce_service.enums.CouponStatus;
import com.nayzak_shop.ecommerce_service.enums.CouponType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "coupons")
public class Coupon extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code", nullable = false)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CouponType type;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "discount", nullable = false)
    private BigDecimal discount;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "min_spend", nullable = false)
    private BigDecimal minSpend;

    @Column(name = "max_spend")
    private BigDecimal maxSpend;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private CouponStatus status;

}
