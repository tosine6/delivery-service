package com.diplomaticdelivery.diplomatic.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private String accountNumber;
    private BigDecimal accountBalance;
    private UUID userId;

}
