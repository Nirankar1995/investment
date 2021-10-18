package com.investment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "holding")
@Getter
@Setter
public class Holding {
    @Id
    @Column(name = "holding_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "holding_name", nullable = false)
    private String holdingName;

    @Column(name = "holding_count")
    private long holdingCount;

    @Column(name = "holding_cost")
    private long holdingCost;

    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;
}
