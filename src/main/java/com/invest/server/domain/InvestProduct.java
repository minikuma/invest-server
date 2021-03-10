package com.invest.server.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class InvestProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invest_product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invest_id")
    private Invest invest;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int investingAmount;
    private int investorCount;

    public static InvestProduct createInvestProduct(Product product, int investingAmount) {
        InvestProduct investProduct = new InvestProduct();
        investProduct.setProduct(product);
        investProduct.setInvestingAmount(investingAmount);
        product.addInvestorCount();
        product.addInvestingAmount(investingAmount);
        return investProduct;
    }

}
