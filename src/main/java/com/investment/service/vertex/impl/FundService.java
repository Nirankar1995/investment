package com.investment.service.vertex.impl;

import com.investment.dto.InvestmentDTO;
import com.investment.dto.VertexServiceType;
import com.investment.entity.Fund;
import com.investment.entity.Investor;
import com.investment.repository.FundRepository;
import com.investment.repository.InvestorRepository;
import com.investment.service.vertex.IVertexService;
import com.investment.util.InvestmentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FundService implements IVertexService {

    private static final Logger logger = LoggerFactory.getLogger(FundService.class);

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    FundRepository fundRepository;

    @Override
    public void createVertexRelationship(InvestmentDTO investmentDTO) {
        Optional<Investor> investorOptional = investorRepository.findByInvestorName(investmentDTO.getParentNode());
        Investor investor;
        if (!investorOptional.isPresent()) {
            investor = InvestmentUtil.populateInvestorData(investmentDTO);
            investorRepository.save(investor);
            logger.info("Investor Id : "+ investor.getId());
        } else {
            investor = investorOptional.get();
        }
        Optional<Fund> fundOptional = fundRepository.findByFundName(investmentDTO.getChildNode());
        if (!fundOptional.isPresent()) {
            Fund fund = InvestmentUtil.populateFundData(investmentDTO);
            fund.setInvestor(investor);
            fundRepository.save(fund);
            logger.info("Fund Id : "+ fund.getId());
        }
    }

    @Override
    public VertexServiceType getVertexServiceType() {
        return VertexServiceType.FundService;
    }


}
