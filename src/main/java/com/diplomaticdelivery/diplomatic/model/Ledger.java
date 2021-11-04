package com.diplomaticdelivery.diplomatic.model;

import com.diplomaticdelivery.diplomatic.enums.CurrencyCode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "ledgers")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ledger{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;
    private BigDecimal previousBalance = BigDecimal.ZERO;
    private BigDecimal newBalance = BigDecimal.ZERO;
    private BigDecimal transactionAmount = BigDecimal.ZERO;
    private String transactionDescription;
    private String paymentReference;

    @Column(name = "currencyCode")
    @Enumerated(EnumType.STRING)
    private CurrencyCode currencyCode;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User actionedUser;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;

    @CreationTimestamp
    @Column(name = "executionDate", nullable = false)
    private LocalDateTime executionDate;
}
