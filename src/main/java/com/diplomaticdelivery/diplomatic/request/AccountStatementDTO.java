package com.diplomaticdelivery.diplomatic.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountStatementDTO {

    private String accountNumber;
}
