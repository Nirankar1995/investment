package com.investment.service.vertex.impl;

import com.investment.dto.InvestmentDTO;
import com.investment.dto.VertexServiceType;
import com.investment.entity.Fund;
import com.investment.entity.Holding;
import com.investment.repository.FundRepository;
import com.investment.repository.HoldingRepository;
import com.investment.service.vertex.IVertexService;
import com.investment.util.InvestmentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HoldingService implements IVertexService {

    private static final Logger logger = LoggerFactory.getLogger(HoldingService.class);

    @Autowired
    FundRepository fundRepository;

    @Autowired
    HoldingRepository holdingRepository;

    @Override
    public void createVertexRelationship(InvestmentDTO investmentDTO) {
        Optional<Fund> fundOptional = fundRepository.findByFundName(investmentDTO.getParentNode());
        Fund fund;
        if (!fundOptional.isPresent()) {
            fund = InvestmentUtil.populateFundData(investmentDTO);
            fundRepository.save(fund);
            logger.info("Fund Id : "+ fund.getId());
        } else {
            fund = fundOptional.get();
        }
        Optional<Holding> holdingOptional = holdingRepository.findByHoldingName(investmentDTO.getChildNode());
        if (!holdingOptional.isPresent()) {
            Holding holding = InvestmentUtil.populateHoldingData(investmentDTO);
            holding.setFund(fund);
            holdingRepository.save(holding);
        }
    }

    @Override
    public VertexServiceType getVertexServiceType() {
        return VertexServiceType.HoldingService;
    }
}
