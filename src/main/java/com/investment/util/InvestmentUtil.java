package com.investment.util;

import com.investment.dto.InvestmentDTO;
import com.investment.entity.Fund;
import com.investment.entity.Holding;
import com.investment.entity.Investor;

public class InvestmentUtil {

    public static Investor populateInvestorData(InvestmentDTO investmentDTO) {
        Investor investor = new Investor();
        investor.setInvestorName(investmentDTO.getParentNode());
        return  investor;
    }

    public static Fund populateFundData(InvestmentDTO investmentDTO) {
        Fund fund = new Fund();
        fund.setFundName(investmentDTO.getChildNode());
        return fund;
    }

    public static Holding populateHoldingData(InvestmentDTO investmentDTO) {
        Holding holding = new Holding();
        holding.setHoldingName(investmentDTO.getChildNode());
        holding.setHoldingCost(investmentDTO.getHoldingCost());
        holding.setHoldingCount(investmentDTO.getHoldingCount());
        return holding;
    }

}
