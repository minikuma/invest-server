package com.invest.server.domain;

import com.invest.server.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("BaseTimeEntity 의 투자 시작일 투자 종료일이 세팅한 일자와 동일한지 확인한다.")
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2021, 3, 9, 0, 0, 0);
        productRepository.save(new Product());

        // when
        List<Product> productList = productRepository.findAll();

        // then
        Product product = productList.get(0);

        assertTrue(product.getCreatedAt().isAfter(now));
        assertTrue(product.getFinishedAt().isAfter(now));
    }
}