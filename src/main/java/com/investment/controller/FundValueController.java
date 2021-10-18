package com.investment.controller;

import com.investment.service.IFundValueService;
import com.investment.service.IInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FundValueController {

    @Autowired
    IFundValueService iFundValueService;

    @GetMapping("/fund/value/{id}")
    public ResponseEntity calculateFundMarketValue(@PathVariable("id") long id) throws Exception {
        long marketValue = iFundValueService.calculateFundMarketValue(id);
        return ResponseEntity.ok().body("Market Value :" + marketValue);
    }
}
