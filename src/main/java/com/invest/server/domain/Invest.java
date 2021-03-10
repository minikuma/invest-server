package com.invest.server.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 투자 도메인 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Invest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invest_id")
    private Long investId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "investing_amount")
    private int investingAmount;

    @Builder
    public Invest(Long productId, Long userId, int investingAmount) {
        this.productId = productId;
        this.userId = userId;
        this.investingAmount = investingAmount;
    }
}
