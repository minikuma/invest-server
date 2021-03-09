package com.invest.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 투자 상태 도메인 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class InvestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    @Column
    private Long productId;

    @Column
    private int currentInvestingAmount;

    @Column
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
}
