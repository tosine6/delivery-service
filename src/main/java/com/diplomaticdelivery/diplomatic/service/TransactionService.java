package com.diplomaticdelivery.diplomatic.service;

import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.request.TransactionDTO;

import java.util.List;

public interface TransactionService {

    Transaction save(TransactionDTO request);
    List<Transaction> fetchAll();
}
