package com.diplomaticdelivery.diplomatic.responseDto;

import com.diplomaticdelivery.diplomatic.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String accountNumber;
    private BigDecimal accountBalance;
    private String accountHolder;
}
