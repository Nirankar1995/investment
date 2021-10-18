package com.investment.service.vertex;

import com.investment.dto.InvestmentDTO;
import com.investment.dto.VertexServiceType;

public interface IVertexService {
    void createVertexRelationship(InvestmentDTO investmentDTO);
    VertexServiceType getVertexServiceType();
}
