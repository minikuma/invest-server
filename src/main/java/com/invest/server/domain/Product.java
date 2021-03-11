package com.invest.server.domain;

import com.invest.server.exception.CustomException;
import com.invest.server.exception.NotEnoughProductException;
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

    @Column(name = "recruit_status")
    private String recruitStatus;

    @Column(name = "product_period")
    private int productPeriod;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<InvestProduct> investProducts = new ArrayList<>();


    // TODO: 비즈니스 로직
    public void addInvestorCount() {
        this.investorCount++;
    }

    public void addInvestingAmount(int amount) {
        int resultAmount = this.currentInvestingAmount + amount;
        if (resultAmount > this.totalInvestingAmount) {
            // TODO: Sold-out 처리
            throw new NotEnoughProductException();
        }
        this.currentInvestingAmount = resultAmount;
    }
}
