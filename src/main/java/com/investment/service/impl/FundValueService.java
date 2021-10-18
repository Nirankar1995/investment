package com.investment.service.impl;

import com.investment.entity.Fund;
import com.investment.exception.InvestmentException;
import com.investment.repository.FundRepository;
import com.investment.service.IFundValueService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class FundValueService implements IFundValueService {

    @Autowired
    FundRepository fundRepository;

    @Override
    public long calculateFundMarketValue(long id) throws Exception {
        Optional<Fund> fundOptional = fundRepository.findById(id);
        long result;
        if (fundOptional.isPresent()) {
            Fund fund = fundOptional.get();
            result = fund.getHoldings().stream().map(holding -> holding.getHoldingCost() * holding.getHoldingCount()).mapToLong(Long::longValue).sum();
        } else {
            throw new InvestmentException("Fund id "+ id + " is not available");
        }
        return result;
    }

    public FundValueService(FundRepository fundRepository) {
        this.fundRepository = fundRepository;
    }
}
