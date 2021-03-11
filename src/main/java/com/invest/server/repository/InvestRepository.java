package com.invest.server.repository;

import com.invest.server.domain.Invest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestRepository extends JpaRepository<Invest, Long> {
    List<Invest> findInvestByUserId(Long userId);
}
