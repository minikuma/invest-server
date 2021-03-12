package com.invest.server.service;

import com.invest.server.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    void 전체상품조회() {
        int expectedCount = 1;
        // given: Local 에 구성하여 미리 등록된 상품 정보 기준
        // when
        // then
    }

    @Test
    void 상품ID기준조회_예상값비교() {
        // given
        String expected = "모집완료";
        // when
        Product productByProductId = productService.productByProductId(1L);
        // then
        assertEquals(productByProductId.getRecruitStatus(), expected);
    }
}