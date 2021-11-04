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
public class AccountBalanceDTO {

    private BigDecimal amount;
    private String senderAccountNumber;
    private String receiverAccountNumber;
}
