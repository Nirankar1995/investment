package com.investment.service.impl;

import com.investment.dto.InvestmentDTO;
import com.investment.dto.VertexServiceType;
import com.investment.exception.InvestmentException;
import com.investment.service.IInvestmentService;
import com.investment.service.vertex.IVertexService;
import com.investment.service.vertex.factory.VertexFactory;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class InvestmentService implements IInvestmentService {

    @Autowired
    VertexFactory vertexFactory;

    @Override
    public void createVertexRelationship(InvestmentDTO investmentDTO) throws Exception {
        if (null != investmentDTO && investmentDTO.getLevel() >= 1 && investmentDTO.getLevel() <= 3) {
            VertexServiceType vertexServiceType = VertexServiceType.values()[investmentDTO.getLevel()-1];
            IVertexService iVertexService = vertexFactory.getServiceInstance(vertexServiceType);
            iVertexService.createVertexRelationship(investmentDTO);
        } else {
            throw new InvestmentException("Level is not in the range of 1 to 3");
        }
    }

}
