package com.diplomaticdelivery.diplomatic.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private String accountNumber;
    private BigDecimal transactionAmount;
    private String senderName;
//    private UUID user;
}
