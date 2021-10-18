package com.investment.controller;

import com.investment.dto.InvestmentDTO;
import com.investment.service.IInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class InvestmentController {

    @Autowired
    IInvestmentService iInvestmentService;

    @PostMapping("/create/vertex/relationship")
    public ResponseEntity createVertexRelationship(@RequestBody InvestmentDTO investmentDTO) throws Exception {
        iInvestmentService.createVertexRelationship(investmentDTO);
        return ResponseEntity.ok().build();
    }
}
