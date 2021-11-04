package com.diplomaticdelivery.diplomatic.model;

import com.diplomaticdelivery.diplomatic.enums.AccountType;
import com.diplomaticdelivery.diplomatic.enums.CurrencyCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;


@Entity
@Table(name = "accounts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{

    private String accountName;
    @Column(name = "accountNumber", unique = true)
    private String accountNumber;
    @Column(name = "accountBalance")
    private BigDecimal accountBalance = BigDecimal.ZERO;
    @Column(name = "previousBalance")
    private BigDecimal previousBalance = BigDecimal.ZERO;
    private boolean active;

    @Column(name = "currencyCode")
    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode = CurrencyCode.USD;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @JsonIgnore
    @ManyToOne
    private User accountHolder;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private Collection<Ledger> ledger;

}
