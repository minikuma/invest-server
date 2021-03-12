package com.invest.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "invest_product")
public class InvestProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invest_product_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "invest_id")
    private Invest invest;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int investingAmount; // 투자 가격

    // 상품 투자 생성 메서드
    public static InvestProduct createInvestProduct(Product product, int investingAmount) {
        InvestProduct investProduct = new InvestProduct();
        investProduct.setProduct(product);
        investProduct.setInvestingAmount(investingAmount);
        product.addInvestorCount();
        product.addInvestingAmount(investingAmount);
        return investProduct;
    }
}
