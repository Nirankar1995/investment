package com.investment.service;

import com.investment.dto.InvestmentDTO;

public interface IInvestmentService {
    void createVertexRelationship(InvestmentDTO investmentDTO)throws Exception;
}
