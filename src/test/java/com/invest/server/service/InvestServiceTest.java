package com.invest.server.service;

import com.invest.server.domain.Invest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class InvestServiceTest {

    @Autowired
    private InvestService investService;

    @Test
    void 상품투자정보등록() {
        // given
        Invest invest = Invest.builder()
                .investingAmount(1000)
                .productId(1000L)
                .userId(1000L).build();
        // when
        // TODO: 입력된 투자 아이디 기준으로 투자 테이블 조회 후 판단
        // then
    }
}