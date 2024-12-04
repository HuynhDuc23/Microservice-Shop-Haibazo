package com.nayzak_shop.ecommerce_service.enums;

public enum CouponStatus {
    ACTIVE, // Coupon còn hiệu lực
    EXPIRED, // Coupon đã hết hạn
    USED, // Coupon đã được sử dụng
    INACTIVE, // Coupon không thể sử dụng
    PENDING // Coupon đang chờ xử lý
}
