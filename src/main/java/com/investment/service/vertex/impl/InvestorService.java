package com.investment.service.vertex.impl;

import com.investment.dto.InvestmentDTO;
import com.investment.dto.VertexServiceType;
import com.investment.entity.Investor;
import com.investment.repository.InvestorRepository;
import com.investment.service.vertex.IVertexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestorService implements IVertexService {

    private static final Logger logger = LoggerFactory.getLogger(InvestorService.class);

    @Autowired
    InvestorRepository investorRepository;

    @Override
    public void createVertexRelationship(InvestmentDTO investmentDTO) {
        Optional<Investor> investorOptional = investorRepository.findByInvestorName(investmentDTO.getChildNode());
        if(!investorOptional.isPresent()){
            Investor investor = populateInvestorData(investmentDTO);
            investorRepository.save(investor);
            logger.info("Investor Id : "+ investor.getId());
        }
    }

    @Override
    public VertexServiceType getVertexServiceType() {
        return VertexServiceType.InvestorService;
    }

    private Investor populateInvestorData(InvestmentDTO investmentDTO) {
        Investor investor = new Investor();
        investor.setInvestorName(investmentDTO.getChildNode());
        return  investor;
    }
}
