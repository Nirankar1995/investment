package com.investment.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "fund")
@Getter
@Setter
public class Fund {
    @Id
    @Column(name = "fund_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fund_name", nullable = false)
    private String fundName;

    @OneToMany(mappedBy = "fund")
    private Set<Holding> holdings;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;

}
