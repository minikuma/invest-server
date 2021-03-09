package com.invest.server.api;

import com.invest.server.dto.ProductDto;
import com.invest.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 투자 상품 API 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ProductApiController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    /**
     * 전체 상품 조회
     * @return 상품 리스트
     */
    @GetMapping("/products")
    public List<ProductDto> productAll() {
        return productService.productList()
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    // TODO: 투자하기 API

    // TODO: 내가 투자한 투자 목록 API

}
