package com.invest.server.domain;

import com.invest.server.repository.InvestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InvestTest {

    @Autowired
    private InvestRepository investRepository;

    @Test
    void invest_저장_테스트() {
        // given
        Invest invest = Invest.builder()
                .investingAmount(100)
                .productId(1L)
                .userId(9000L)
                .build();
        // when
        investRepository.save(invest);
        List<Invest> findInvest = investRepository.findInvestByUserId(9000L);
        Invest firstInvest = findInvest.get(0);
        // then
        assertEquals(firstInvest.getInvestId(), invest.getInvestId());
    }
}