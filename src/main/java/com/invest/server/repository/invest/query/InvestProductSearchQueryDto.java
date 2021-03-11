package com.invest.server.repository.invest.query;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class InvestProductSearchQueryDto {
    private Long productId;          // 상품아이디
    private String title;            // 상품제목
    private int totalInvestingAmount;// 총 모집금액
    private int investingAmount;     // 나의투자금액
    private LocalDateTime createdAt; // 투자일시

    public InvestProductSearchQueryDto(Long productId, String title, int totalInvestingAmount, int investingAmount, LocalDateTime createdAt) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.investingAmount = investingAmount;
        this.createdAt = createdAt;
    }
}
