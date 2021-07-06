package com.diplomaticdelivery.diplomatic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@Table(name = "accounts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity{

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "accountBalance")
    private BigDecimal accountBalance;

    @JsonIgnore
    @ManyToOne
    private User accountHolder;

}
