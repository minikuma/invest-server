package com.invest.server.service;

import com.invest.server.domain.Invest;
import com.invest.server.domain.InvestProduct;
import com.invest.server.domain.Product;
import com.invest.server.dto.InvestRequestDto;
import com.invest.server.repository.InvestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InvestService {

    private final InvestRepository investRepository;
    private final ProductService productService;
    /**
     * 상품 투자
     * @param
     * @return
     */
    public Long investProduct(Long userId, InvestRequestDto request) {
        //TODO: 유입된 상품 아이디 기준으로 상품정보 조회
        Product product = productService.productByProductId(request.getProductId());
        InvestProduct investProduct = InvestProduct.createInvestProduct(product, request.getInvestingAmount());
        Invest invest = Invest.builder()
                .productId(investProduct.getProduct().getProductId())
                .userId(userId)
                .investingAmount(investProduct.getInvestingAmount())
                .build();
        investRepository.save(invest);
        return invest.getInvestId();
    }
}
