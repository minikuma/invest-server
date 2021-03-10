package com.invest.server.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "title", length = 100, nullable = false)
    private String title;

    @Column(name = "total_investing_amount", nullable = false)
    @ColumnDefault("0")
    private int totalInvestingAmount;

    @Column(name = "current_investing_amount", nullable = false)
    @ColumnDefault("0")
    private int currentInvestingAmount;

    @Column(name = "investor_count", nullable = false)
    @ColumnDefault("0")
    private int investorCount;

    @Column(name = "recruit_status")
    private String recruitStatus;

    @Column(name = "product_period")
    private int productPeriod;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InvestProduct> investProducts = new ArrayList<>();

    @Builder
    public Product(Long productId, String title, int totalInvestingAmount, int currentInvestingAmount, int investorCount, String recruitStatus, int productPeriod) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.currentInvestingAmount = currentInvestingAmount;
        this.investorCount = investorCount;
        this.recruitStatus = recruitStatus;
        this.productPeriod = productPeriod;
    }

    public void addInvestorCount() {
        this.investorCount++;
    }

    public void addInvestingAmount(int amount) {
        int resultAmount = this.currentInvestingAmount + amount;
        if (resultAmount > this.totalInvestingAmount) {
            // TODO: Sold-out 처리
        }
        this.currentInvestingAmount = resultAmount;
    }
}
