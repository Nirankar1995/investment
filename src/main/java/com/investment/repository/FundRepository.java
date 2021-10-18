package com.investment.repository;

import com.investment.entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FundRepository extends JpaRepository<Fund, Long> {
    Optional<Fund> findByFundName(String fundName);
}
