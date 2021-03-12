package com.invest.server.domain;

import com.invest.server.exception.biz.NotEnoughProductException;
import lombok.*;
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
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "product")
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

    @Enumerated(EnumType.STRING)
    @Column(name = "recruit_status")
    private RecruitCode recruitCode;

    @Column(name = "product_period")
    private int productPeriod;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InvestProduct> investProducts = new ArrayList<>();


    /**
     * 투자 도메인 투자자 증가 메서드
     */
    public void addInvestorCount() {
        this.investorCount++;
    }

    /**
     * 투자 금액 증가 메서드
     * @param amount (투자금액)
     */
    public void addInvestingAmount(int amount) {
        int resultAmount = this.currentInvestingAmount + amount;
        // 현재 상품의 투자 금액과 투자할 금액 비교 (투자 금액은 총 투자금액을 넘을 수 없음)
        if (resultAmount > this.totalInvestingAmount) {
            throw new NotEnoughProductException();
        }
        // 총 상품 투자금액과 투자한 금액이 일치하는 경우 상품 투자 모집 마감 처리
        if (resultAmount == this.totalInvestingAmount) {
            this.setRecruitCode(RecruitCode.모집완료);
        }
        this.currentInvestingAmount = resultAmount;
    }
    @Builder
    public Product(Long productId, String title, int totalInvestingAmount, int currentInvestingAmount, int investorCount, RecruitCode recruitCode, int productPeriod) {
        this.productId = productId;
        this.title = title;
        this.totalInvestingAmount = totalInvestingAmount;
        this.currentInvestingAmount = currentInvestingAmount;
        this.investorCount = investorCount;
        this.recruitCode = recruitCode;
        this.productPeriod = productPeriod;
    }
}
