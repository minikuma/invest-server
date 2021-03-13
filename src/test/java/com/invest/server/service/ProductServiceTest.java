package com.invest.server.service;

import com.invest.server.domain.Product;
import com.invest.server.domain.RecruitCode;
import com.invest.server.exception.ErrorCode;
import com.invest.server.exception.biz.NotFoundProductException;
import com.invest.server.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;

    private static Product product;

    @BeforeTestMethod
    public void productInit() {
        product = Product.builder()
                .productId(1L)
                .title("TITLE")
                .currentInvestingAmount(10000)
                .recruitCode(RecruitCode.모집중)
                .investorCount(3)
                .totalInvestingAmount(10000000)
                .productPeriod(100)
                .build();
    }

    @Test
    void 전체상품조회() {
        // given: Product 저장
        productInit();
        productRepository.save(product);

        // when
        List<Product> findProducts = productRepository.findAll();

        // then
        assertEquals(findProducts.size(), 1);
        assertEquals(findProducts.get(0).getProductId(), product.getProductId());
        assertEquals(findProducts.get(0).getTitle(), product.getTitle());
        assertEquals(findProducts.get(0).getRecruitCode(), product.getRecruitCode());
    }

    @Test
    void 전체상품조회_현재날짜시간기준() {
        // given: Product 저장
        productInit();
        productRepository.save(product);

        // when
        List<Product> findProducts = productRepository.findProductByCurrent(LocalDateTime.now());

        // then
        assertEquals(findProducts.size(), 0);
    }


    @Test
    void 상품아이디기준조회() {
        // given
        productInit();
        productRepository.save(product);

        // when
        Product findProduct = productRepository.findById(product.getProductId()).orElseThrow(NotFoundProductException::new);

        // then
        assertEquals(findProduct.getProductId(), product.getProductId());
    }

    @Test
    void NotFoundProductException_예외테스트() {
        // given
        Product exceptionProduct = Product.builder()
                .productId(2L)
                .build();

        // when
        NotFoundProductException exception = assertThrows(NotFoundProductException.class, () -> {
            Product findProduct = productRepository.findById(exceptionProduct.getProductId()).orElseThrow(NotFoundProductException::new);
        });

        // then
        assertEquals(exception.getErrorCode(), ErrorCode.NOT_FOUND);
    }
}