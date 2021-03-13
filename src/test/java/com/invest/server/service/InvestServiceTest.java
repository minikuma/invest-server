package com.invest.server.service;

import com.invest.server.domain.Invest;
import com.invest.server.domain.InvestProduct;
import com.invest.server.domain.Product;
import com.invest.server.domain.RecruitCode;
import com.invest.server.dto.InvestRequestDto;
import com.invest.server.exception.biz.NotFoundProductException;
import com.invest.server.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InvestServiceTest {

    @Autowired
    private ProductRepository productRepository;

    private static Product product;
    private static InvestRequestDto investRequestDto;

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
        investRequestDto = new InvestRequestDto(10, product.getProductId());
    }

    @Test
    void 상품아이디기준으로상품조회() {
        // given
        productInit();

        // when
        Product findProduct = productRepository.findById(product.getProductId()).orElseThrow(NotFoundProductException::new);

        // then
        assertEquals(product.getProductId(), findProduct.getProductId());
    }

    @Test
    void 투자상품생성() {
        // given
        productInit();

        // when
        InvestProduct createInvestProduct = InvestProduct.createInvestProduct(product, investRequestDto.getInvestingAmount());
        Invest invest = Invest.createInvest(9L, product.getProductId(), investRequestDto.getInvestingAmount(), createInvestProduct);

        // then
        assertEquals(createInvestProduct.getInvestingAmount(), investRequestDto.getInvestingAmount());
        assertEquals(invest.getInvestingAmount(), investRequestDto.getInvestingAmount());
    }
}