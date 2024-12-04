package com.nayzak_shop.ecommerce_service.enums;

public enum CouponType {
    GENERAL,            // Áp dụng cho tất cả mọi người
    WOMEN_ONLY,         // Chỉ áp dụng cho phụ nữ
    MEN_ONLY,           // Chỉ áp dụng cho nam giới
    AGE_GROUP,          // Áp dụng cho một nhóm tuổi cụ thể
    NEW_USER,           // Áp dụng cho người dùng mới
    LOYAL_CUSTOMER,     // Áp dụng cho khách hàng thân thiết
    SEASONAL,           // Áp dụng cho các dịp lễ, mùa giảm giá
    FESTIVAL,           // Áp dụng cho các dịp lễ hội (Tết, Giáng Sinh, ...)
    FIRST_ORDER,        // Áp dụng cho đơn hàng đầu tiên
    BULK_PURCHASE,      // Áp dụng khi mua số lượng lớn
    MIN_PURCHASE,       // Áp dụng khi đạt giá trị đơn hàng tối thiểu
    REFERRED_USER,      // Áp dụng cho người dùng được giới thiệu
    REFERRAL_DISCOUNT,  // Áp dụng cho người giới thiệu
    STUDENT_ONLY,       // Áp dụng cho học sinh/sinh viên
    EMPLOYEE_ONLY,      // Áp dụng cho nhân viên nội bộ
    BIRTHDAY_SPECIAL,   // Áp dụng cho sinh nhật khách hàng
    ANNIVERSARY,        // Áp dụng cho ngày kỷ niệm (ví dụ: kỷ niệm thành lập công ty)
    LOCATION_BASED,     // Áp dụng cho một khu vực địa lý cụ thể
    ONLINE_ONLY,        // Áp dụng cho đơn hàng online
    IN_STORE_ONLY,      // Áp dụng cho mua hàng trực tiếp tại cửa hàng
    LIMITED_USE,        // Mã giảm giá chỉ được sử dụng một số lần giới hạn
    CATEGORY_SPECIFIC,  // Áp dụng cho một danh mục sản phẩm cụ thể
    PRODUCT_SPECIFIC,   // Áp dụng cho một sản phẩm cụ thể
    FREE_SHIPPING,      // Miễn phí vận chuyển
    BUY_ONE_GET_ONE,    // Mua 1 tặng 1
    FLASH_SALE,         // Áp dụng trong các chương trình khuyến mãi nhanh
    BLACK_FRIDAY,       // Áp dụng trong dịp Black Friday
    CYBER_MONDAY        // Áp dụng trong dịp Cyber Monday
}

