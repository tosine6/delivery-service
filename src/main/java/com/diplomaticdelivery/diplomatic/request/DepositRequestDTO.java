package com.diplomaticdelivery.diplomatic.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequestDTO {

    private UUID sender;
    private UUID receiver;
    private String amount;

}
