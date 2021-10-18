package com.investment;

import com.investment.entity.Fund;
import com.investment.entity.Holding;
import com.investment.entity.Investor;
import com.investment.repository.FundRepository;
import com.investment.repository.InvestorRepository;
import com.investment.service.impl.FundValueService;
import com.investment.service.impl.InvestorValueService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class InvestmentApplicationTests {

	@Test
	public void testFundMarketValue() throws Exception {
		FundRepository fundRepository = mock(FundRepository.class);

		Fund fund = new Fund();
		fund.setId(3L);
		fund.setFundName("f1");
		Set<Holding> holdingSet = new HashSet<>();
		Holding holding = new Holding();
		holding.setId(4L);
		holding.setHoldingName("h1");
		holding.setHoldingCost(10);
		holding.setHoldingCount(100);
		holdingSet.add(holding);
		fund.setHoldings(holdingSet);

		Optional<Fund> fundOptional = Optional.of(fund);
		when(fundRepository.findById(3L)).thenReturn(fundOptional);

		FundValueService fundValueService = new FundValueService(fundRepository);
		long marketValue = fundValueService.calculateFundMarketValue(3);
		Assertions.assertEquals(marketValue, 1000);
	}


	@Test
	public void testInvestorMarketValue() throws Exception {
		InvestorRepository investorRepository = mock(InvestorRepository.class);

		Investor investor = new Investor();
		investor.setId(1L);
		investor.setInvestorName("inv1");
		Set<Fund> funds = new HashSet<>();
		Fund fund = new Fund();
		fund.setId(3L);
		fund.setFundName("f1");
		Set<Holding> holdingSet = new HashSet<>();
		Holding holding = new Holding();
		holding.setId(4L);
		holding.setHoldingName("h1");
		holding.setHoldingCost(10);
		holding.setHoldingCount(100);
		holdingSet.add(holding);
		fund.setHoldings(holdingSet);

		Fund fund1 = new Fund();
		fund1.setId(4L);
		fund1.setFundName("f2");
		fund1.setHoldings(holdingSet);
		funds.add(fund);
		funds.add(fund1);
		investor.setFunds(funds);

		Optional<Investor> investorOptional = Optional.of(investor);
		when(investorRepository.findById(1L)).thenReturn(investorOptional);
		InvestorValueService investorValueService = new InvestorValueService(investorRepository);
		long marketValue = investorValueService.calculateInvestorMarketValue(1);
		Assertions.assertEquals(marketValue, 2000);
	}
}
