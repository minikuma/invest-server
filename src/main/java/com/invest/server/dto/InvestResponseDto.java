package com.invest.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 상품 투자 요청 시 응답 DTO 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Data
@AllArgsConstructor
public class InvestResponseDto {
    private Long productId;
}
