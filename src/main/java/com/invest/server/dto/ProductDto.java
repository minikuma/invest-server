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
    private Long productId;         // 상품 ID
    private String title;           // 상품 제목
    private int totalInvestingAmount;  // 총 모집금액
    private int currentInvestingAmount;// 현재 모집금액
    private int investorCount;      // 투자자 수
    private String recruitStatus;   // 투자모집상태(모집중, 모집완료)
    private int productPeriod;      // 상품모집기간
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.title = product.getTitle();
        this.totalInvestingAmount = product.getTotalInvestingAmount();
        this.currentInvestingAmount = product.getCurrentInvestingAmount();
        this.investorCount = product.getInvestorCount();
        this.recruitStatus = product.getRecruitStatus();
        this.productPeriod = product.getProductPeriod();
        this.createdAt = product.getCreatedAt();
        this.finishedAt = product.getFinishedAt();
    }
}
