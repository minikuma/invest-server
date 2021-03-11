package com.invest.server.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 투자 도메인 클래스
 * @version 1.0
 * @author Jeon Jihoon
 */

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "invest")
public class Invest extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invest_id")
    private Long investId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "investing_amount")
    private int investingAmount;

    @OneToMany(mappedBy = "invest", cascade = CascadeType.ALL)
    private List<InvestProduct> investProducts = new ArrayList<>();


    public void addInvestProduct(InvestProduct investProduct) {
        investProducts.add(investProduct);
        investProduct.setInvest(this);
    }

    // TODO: 생성메서드
    public static Invest createInvest(Long userId, Long productId, int investingAmount, InvestProduct... investProducts) {
        Invest invest = new Invest();
        for (InvestProduct ip : investProducts) {
            invest.addInvestProduct(ip);
        }
        invest.setProductId(productId);
        invest.setInvestingAmount(investingAmount);
        invest.setUserId(userId);
        return invest;
    }
}
