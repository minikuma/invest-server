package com.invest.server.service;

import com.invest.server.domain.Invest;
import com.invest.server.domain.Product;
import com.invest.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * 전체 상품 조회
     * @return 상품 리스트
     */
    public List<Product> productList() {
        return productRepository.findAll();
    }

    /**
     * product 아이디 기준으로 상품 조회
     * @param productId (상품아이디)
     * @return 상품 정보
     */
    public Product productByProductId(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> new NoSuchElementException("No Search Data"));
    }
}
