package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.repository.TransactionRepository;
import com.diplomaticdelivery.diplomatic.requestDto.TransactionDTO;
import com.diplomaticdelivery.diplomatic.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public Transaction save(TransactionDTO request) {
        logger.info("saving transaction...");
        Transaction newTransaction = mapper.map(request, Transaction.class);

        transactionRepository.save(newTransaction);
        logger.info("done saving transaction...");
        return newTransaction;
    }

    @Override
    public List<Transaction> fetchAll() {
        logger.info("fetching all transactions...");
        return transactionRepository.findAll();
    }
}
