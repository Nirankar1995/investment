package com.investment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "investor")
@Getter
@Setter
public class Investor {
    @Id
    @Column(name = "investor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "investor_name", nullable = false)
    private String investorName;

    @OneToMany(mappedBy = "investor")
    private Set<Fund> funds;
}
