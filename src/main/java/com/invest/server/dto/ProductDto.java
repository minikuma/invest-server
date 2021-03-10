package com.invest.server.dto;

import com.invest.server.domain.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 전체투자상품조회 응답을 위한 DTO 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@NoArgsConstructor
@Data
public class ProductDto {
    private Long productId;
    private String title;
    private int totalInvestingAmount;
    private int productPeriod;
    private String recruitStatus;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.title = product.getTitle();
        this.totalInvestingAmount = product.getTotalInvestingAmount();
        this.productPeriod = product.getProductPeriod();
        this.recruitStatus = product.getRecruitStatus();
        this.createdAt = product.getCreatedAt();
        this.finishedAt = product.getFinishedAt();
    }
}
