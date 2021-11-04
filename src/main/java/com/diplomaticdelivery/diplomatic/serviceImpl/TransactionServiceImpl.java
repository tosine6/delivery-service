package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.repository.TransactionRepository;
import com.diplomaticdelivery.diplomatic.request.TransactionDTO;
import com.diplomaticdelivery.diplomatic.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private com.diplomaticdelivery.diplomatic.service.AccountService accountService;

    ModelMapper mapper = new ModelMapper();

    @Override
    @Transactional
    public Transaction save(TransactionDTO request) {
        logger.info("saving transaction...");
        Account account = accountService.findByAccountNumber(request.getAccountNumber());
        logger.info("prev balance..."+ account.getAccountBalance());
        account.getAccountBalance().add(request.getTransactionAmount());
        logger.info("new balance..."+ account.getAccountBalance());
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
