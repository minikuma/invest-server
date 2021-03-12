package com.invest.server.repository;

import com.invest.server.domain.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 투자 레파지토리
 * @version 1.0
 * @author Jeon Jihoon
 */

public interface InvestRepository extends JpaRepository<Invest, Long> {
    List<Invest> findInvestByUserId(Long userId);
}
