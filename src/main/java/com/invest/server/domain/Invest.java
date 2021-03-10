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
    private Long investId;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long userId;

    @Column
    private int investAmount;

    @Builder
    public Invest(Long productId, Long userId, int investAmount) {
        this.productId = productId;
        this.userId = userId;
        this.investAmount = investAmount;
    }
}
