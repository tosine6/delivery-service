package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.requestDto.AccountBalanceDTO;
import com.diplomaticdelivery.diplomatic.requestDto.AccountDTO;
import com.diplomaticdelivery.diplomatic.requestDto.AccountStatementDTO;
import com.diplomaticdelivery.diplomatic.responseDto.AccountResponse;
import com.diplomaticdelivery.diplomatic.responseDto.AccountStatementResponse;

import java.util.List;

public interface AccountService {

    Account create(AccountDTO request);
    List<Account> fetchAll();
    Transaction transferFund(AccountBalanceDTO request);
    AccountStatementResponse getAccountStatement(String  accountNumber);
    Account depositFund(AccountDTO request);
    Account findByAccountNumber(String accountNumber);

}
