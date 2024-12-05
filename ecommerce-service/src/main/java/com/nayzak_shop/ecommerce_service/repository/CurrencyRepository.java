package com.nayzak_shop.ecommerce_service.repository;

import com.nayzak_shop.ecommerce_service.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency,String> {
}
