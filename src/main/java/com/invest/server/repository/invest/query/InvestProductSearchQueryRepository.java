package com.invest.server.repository.invest.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InvestProductSearchQueryRepository {

    private final EntityManager em;

    public List<InvestProductSearchQueryDto> findInvertProducts(Long userId) {
        return em.createQuery("SELECT new com.invest.server.repository.invest.query.InvestProductSearchQueryDto(i.productId, p.title, p.totalInvestingAmount, i.investingAmount, i.createdAt)" +
                "FROM Invest i " +
                "LEFT JOIN Product p ON i.productId = p.productId WHERE i.userId = ?1", InvestProductSearchQueryDto.class).setParameter(1, userId).getResultList();
    }
}
