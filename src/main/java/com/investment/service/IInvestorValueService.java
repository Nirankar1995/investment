package com.investment.service;

import com.investment.dto.InvestmentDTO;

public interface IInvestorValueService {
    long calculateInvestorMarketValue(long id)throws Exception;
}
