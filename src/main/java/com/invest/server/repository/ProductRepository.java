package com.invest.server.repository;

import com.invest.server.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 상품 레파지토리
 * @version 1.0
 * @author Jeon Jihoon
 */

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE :current BETWEEN p.startedAt AND p.finishedAt")
    List<Product> findProductByCurrent(LocalDateTime current);
}