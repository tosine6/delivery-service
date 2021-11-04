package com.diplomaticdelivery.diplomatic.response;

import com.diplomaticdelivery.diplomatic.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatementResponse {

    private BigDecimal currentBalance;
    List<Transaction> transactionsHistory;
}
