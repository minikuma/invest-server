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

    /**
     * 투자 도메인과 상품 도메인 연관 관계 설정 메서드
     * @param investProduct (투자상품 연관도메인)
     */
    public void addInvestProduct(InvestProduct investProduct) {
        investProducts.add(investProduct);
        investProduct.setInvest(this);
    }

    /**
     * 투자 생성 메서드
     * @param userId (사용자)
     * @param productId (상품 아이디)
     * @param investingAmount (투자 금액)
     * @param investProducts (투자상품 클래스)
     * @return 투자 클래스
     */

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
