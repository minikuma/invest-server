package com.invest.server.dto;

import lombok.Data;

/**
 * 상품 투자 요청 시 입력 DTO 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Data
public class InvestRequestDto {
    private int investingAmount; // 투자금액
    private Long productId;      // 상품 아이디
}
