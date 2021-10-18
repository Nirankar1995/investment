package com.investment.controller;

import com.investment.service.IInvestmentService;
import com.investment.service.IInvestorValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvestorValueController {

    @Autowired
    IInvestorValueService iInvestorValueService;

    @GetMapping("/investor/value/{id}")
    public ResponseEntity calculateInvestorMarketValue(@PathVariable("id") long id) throws Exception {
        long marketValue = iInvestorValueService.calculateInvestorMarketValue(id);
        return ResponseEntity.ok().body("Market Value :" + marketValue);
    }
}
