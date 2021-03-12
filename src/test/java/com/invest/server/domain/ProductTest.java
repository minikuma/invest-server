package com.invest.server.domain;

import com.invest.server.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("BaseTimeEntity 의 투자 시작일 투자 종료일이 세팅한 일자와 동일한지 확인한다.")
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.of(2021, 3, 13, 0, 0, 0);
        Product product = Product.builder()
                .productId(1L)
                .title("TITLE")
                .productPeriod(32)
                .totalInvestingAmount(200)
                .investorCount(2)
                .recruitCode(RecruitCode.모집중)
                .currentInvestingAmount(1)
                .build();
        productRepository.save(product);

        // when
        List<Product> productList = productRepository.findAll();
        Product findProduct = productList.get(0);

        // then
        assertTrue(findProduct.getStartedAt().isAfter(now));
        assertTrue(findProduct.getFinishedAt().isAfter(now));
    }
}