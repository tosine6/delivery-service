package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.repository.AccountRepository;
import com.diplomaticdelivery.diplomatic.repository.TransactionRepository;
import com.diplomaticdelivery.diplomatic.repository.UserRepository;
import com.diplomaticdelivery.diplomatic.requestDto.AccountBalanceDTO;
import com.diplomaticdelivery.diplomatic.requestDto.AccountDTO;
import com.diplomaticdelivery.diplomatic.requestDto.AccountStatementDTO;
import com.diplomaticdelivery.diplomatic.responseDto.AccountResponse;
import com.diplomaticdelivery.diplomatic.responseDto.AccountStatementResponse;
import com.diplomaticdelivery.diplomatic.service.AccountService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Account create(AccountDTO request) {
        logger.info("saving account...");
        User existingUser = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        ModelMapper mapper = new ModelMapper();
        String accountNumber = generateAccountNumber();

        Account newAccount = mapper.map(request, Account.class);
        newAccount.setAccountHolder(existingUser);
        newAccount.setAccountNumber(accountNumber);

        accountRepository.save(newAccount);
        logger.info("account saved...");
        return newAccount;
    }

    @Override
    public List<Account> fetchAll() {
        logger.info("fetching all accounts...");
        return accountRepository.findAll();
    }

    @Override
    public Transaction transferFund(AccountBalanceDTO request) {
        String senderAccountNo = request.getSenderAccountNumber();
        String receiverAccountNo = request.getReceiverAccountNumber();
        BigDecimal amount = request.getAmount();
        Account senderAccount = findByAccountNumber(senderAccountNo);
        Account receiverAccount = findByAccountNumber(receiverAccountNo);

        if(senderAccount.getAccountBalance().compareTo(BigDecimal.ONE) == 1
                && senderAccount.getAccountBalance().compareTo(amount) == 1){
            senderAccount.setAccountBalance(senderAccount.getAccountBalance().subtract(amount));
            accountRepository.save(senderAccount);

            receiverAccount.setAccountBalance(receiverAccount.getAccountBalance().add(amount));
            accountRepository.save(receiverAccount);

            Transaction transaction = transactionRepository.save(
                    new Transaction(0L, senderAccountNo, receiverAccountNo, amount, LocalDateTime.now()));

            return transaction;
        }
        return null;
    }

    @Override
    public AccountStatementResponse getAccountStatement(String accountNumber) {
        Account userAccount = findByAccountNumber(accountNumber);

        return new AccountStatementResponse(userAccount.getAccountBalance(),
                transactionRepository.findBySenderAccountNumber(userAccount.getAccountNumber()));
    }

    @Override
    public Account depositFund(AccountDTO request) {
        return null;
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(null == account){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found!");
        }
        return account;
    }

    public String generateAccountNumber(){
        long number = (long) (Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L);

        return String.valueOf(number);
    }
}
