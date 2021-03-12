package com.invest.server.api;

import com.invest.server.dto.ProductDto;
import com.invest.server.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 상품 API 컨트롤러
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
     * 전체 상품 조회 (현재기준 유효한 상품목록)
     * @return 상품 리스트
     */
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> productAll() {
        List<ProductDto> products = productService.productList(LocalDateTime.now())
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(products);
    }
}