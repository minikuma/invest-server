package com.invest.server.repository.invest.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 사용자 기준 투자 상품 조회용 JPQL Query
 * @version 1.0
 * @author Jeon Jihoon
 */

@Repository
@RequiredArgsConstructor
public class InvestProductSearchQueryRepository {

    private final EntityManager em;

    public List<InvestProductSearchQueryDto> findInvertProducts(Long userId) {
        return em.createQuery("SELECT new com.invest.server.repository.invest.query.InvestProductSearchQueryDto(i.productId, p.title, p.totalInvestingAmount, i.investingAmount, i.startedAt)" +
                "FROM Invest i " +
                "LEFT JOIN Product p ON i.productId = p.productId WHERE i.userId = ?1", InvestProductSearchQueryDto.class)
                .setParameter(1, userId)
                .getResultList();
    }
}
