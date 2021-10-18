package com.investment.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InvestmentDTO {
    private String parentNode;
    private String childNode;
    private int level;
    private long holdingCount;
    private long holdingCost;
}
