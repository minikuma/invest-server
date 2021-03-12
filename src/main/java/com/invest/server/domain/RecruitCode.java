package com.invest.server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 상품 투자 모집 ENUM 클래스 [PROCESS, COMPLETED]
 * @version 1.0
 * @author Jeon Jihoon
 */

@Getter
@AllArgsConstructor
public enum RecruitCode {
    모집중, 모집완료
}