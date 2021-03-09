package com.invest.server.service;

import com.invest.server.domain.Product;
import com.invest.server.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
