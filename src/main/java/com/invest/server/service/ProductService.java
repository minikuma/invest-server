package com.invest.server.service;

import com.invest.server.domain.Product;
import com.invest.server.exception.biz.NotFoundProductException;
import com.invest.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 상품 서비스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * 전체 상품 조회
     * @return 상품 리스트
     */
    public List<Product> productList(LocalDateTime current) {
        return productRepository.findProductByCurrent(current);
    }

    /**
     * product 상품 아이디 기준으로 상품 조회
     * @param productId (상품아이디)
     * @return 상품 정보
     */
    public Product productByProductId(Long productId) {
        return productRepository.findById(productId).orElseThrow(NotFoundProductException::new);
    }
}
