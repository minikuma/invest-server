package com.invest.server.service;

import com.invest.server.domain.Invest;
import com.invest.server.repository.InvestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvestService {

    private final InvestRepository investRepository;

    /**
     * 상품 투자
     * @param invest
     * @return
     */
    public Long investProduct(Invest invest) {
        investRepository.save(invest);
        return invest.getInvestId();
    }
}
