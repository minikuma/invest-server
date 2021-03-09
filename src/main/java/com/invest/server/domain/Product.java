package com.invest.server.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * 상품 도메인 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int totalInvestingAmount;

    @Builder
    public Product(String title, int totalInvestingAmount) {
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
    }
}
