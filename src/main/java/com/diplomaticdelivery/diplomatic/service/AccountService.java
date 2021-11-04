package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.request.AccountBalanceDTO;
import com.diplomaticdelivery.diplomatic.request.CreateAccountDTO;
import com.diplomaticdelivery.diplomatic.response.AccountStatementResponse;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account create(CreateAccountDTO request);
    List<Account> fetchAll();
    Transaction transferFund(AccountBalanceDTO request);
    AccountStatementResponse getAccountStatement(String  accountNumber);
    Account depositFund(CreateAccountDTO request);
    Account findByAccountNumber(String accountNumber);
    Account fetchUserAccount(UUID userId);

}
