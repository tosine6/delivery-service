package com.diplomaticdelivery.diplomatic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends BaseEntity{

    @Column(name = "transactionId")
    private Long transactionId;

    @Column(name = "senderAccountNumber")
    private String senderAccountNumber;

    @Column(name = "receiverAccountNumber")
    private String receiverAccountNumber;

    @Column(name = "transactionAmount")
    private BigDecimal transactionAmount;

    @Column(name = "transactionDateTime")
    private LocalDateTime transactionDateTime;
}
