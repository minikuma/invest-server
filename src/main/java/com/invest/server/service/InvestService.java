package com.invest.server.service;

import com.invest.server.domain.Invest;
import com.invest.server.domain.InvestProduct;
import com.invest.server.domain.Product;
import com.invest.server.dto.InvestRequestDto;
import com.invest.server.repository.InvestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
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
    @Transactional
    public Long investProduct(Long userId, InvestRequestDto request) {
        //TODO: 유입된 상품 아이디 기준으로 상품정보 조회
        Product product = productService.productByProductId(request.getProductId());
        // TODO: 투자 상품 생성
        InvestProduct investProduct = InvestProduct.createInvestProduct(product, request.getInvestingAmount());
        // TODO: 투자
        Invest invest = Invest.createInvest(userId, product.getProductId(), investProduct.getInvestingAmount(), investProduct);
        investRepository.save(invest);
        return invest.getInvestId();
    }
}
