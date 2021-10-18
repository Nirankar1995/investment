package com.investment.service.impl;

import com.investment.dto.InvestmentDTO;
import com.investment.dto.VertexServiceType;
import com.investment.entity.Fund;
import com.investment.entity.Investor;
import com.investment.exception.InvestmentException;
import com.investment.repository.FundRepository;
import com.investment.repository.InvestorRepository;
import com.investment.service.IInvestmentService;
import com.investment.service.IInvestorValueService;
import com.investment.service.vertex.IVertexService;
import com.investment.service.vertex.factory.VertexFactory;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class InvestorValueService implements IInvestorValueService {

    @Autowired
    InvestorRepository investorRepository;

    @Override
    public long calculateInvestorMarketValue(long id) throws Exception {
        Optional<Investor> investorOptional = investorRepository.findById(id);
        long result;
        if (investorOptional.isPresent()) {
            Investor investor = investorOptional.get();
            result = investor.getFunds().stream().mapToLong(fund -> fund.getHoldings().stream().map(holding -> holding.getHoldingCost() * holding.getHoldingCount()).mapToLong(Long::longValue).sum()).sum();
        } else {
            throw new InvestmentException("Investor id "+ id + " is not available");
        }
        return result;
    }

    public InvestorValueService(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

}
