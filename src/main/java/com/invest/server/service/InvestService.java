package com.invest.server.service;

import com.invest.server.domain.Invest;
import com.invest.server.domain.InvestProduct;
import com.invest.server.domain.Product;
import com.invest.server.dto.InvestRequestDto;
import com.invest.server.dto.InvestResponseDto;
import com.invest.server.repository.InvestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 투자 서비스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class InvestService {

    private final InvestRepository investRepository;
    private final ProductService productService;

    /**
     * 상품 투자 메서드
     * @param userId (사용자)
     * @param request (투자금액, 상품아이디)
     * @return 투자아이디
     */
    @Transactional
    public InvestResponseDto investProduct(Long userId, InvestRequestDto request) {
        // 유입된 상품 아이디 기준으로 상품정보 조회
        Product product = productService.productByProductId(request.getProductId());
        // 투자 상품 생성
        InvestProduct investProduct = InvestProduct.createInvestProduct(product, request.getInvestingAmount());
        // 투자
        Invest invest = Invest.createInvest(userId, product.getProductId(), investProduct.getInvestingAmount(), investProduct);
        investRepository.save(invest);
        return new InvestResponseDto(invest.getInvestId());
    }
}
