package com.diplomaticdelivery.diplomatic.serviceImpl;

import com.diplomaticdelivery.diplomatic.enums.AccountType;
import com.diplomaticdelivery.diplomatic.enums.CurrencyCode;
import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.model.Location;
import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.model.User;
import com.diplomaticdelivery.diplomatic.repository.AccountRepository;
import com.diplomaticdelivery.diplomatic.repository.TransactionRepository;
import com.diplomaticdelivery.diplomatic.repository.UserRepository;
import com.diplomaticdelivery.diplomatic.request.AccountBalanceDTO;
import com.diplomaticdelivery.diplomatic.request.CreateAccountDTO;
import com.diplomaticdelivery.diplomatic.response.AccountStatementResponse;
import com.diplomaticdelivery.diplomatic.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    private BCryptPasswordEncoder passwordEncoder;
    ModelMapper mapper = new ModelMapper();

    @Override
    public Account create(CreateAccountDTO request) {
        log.info("saving account...");
        User existingUser = userRepository.findByName(request.getName());
        if(null != existingUser){throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with name "+request.getName()+" already exist!");}
        User userByEmail = userRepository.findByEmailAddress(request.getEmailAddress());
        if(null != userByEmail){throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User with name "+request.getEmailAddress()+" already exist!");}


        String password = passwordEncoder.encode(request.getPassword());
        LocalDateTime dateOfBirth = LocalDateTime.of(request.getDateOfBirth(), LocalTime.MIDNIGHT);
        Location location = Location.builder().address(request.getLocation().getAddress()).city(request.getLocation().getCity())
                .city(request.getLocation().getCity()).build();
        User newUser = User.builder().name(request.getName()).dateOfBirth(dateOfBirth).emailAddress(request.getEmailAddress())
                .driversLicence(request.getDriversLicence()).ssn(request.getSsn()).password(password).location(location)
                .usertype(User.UserType.CLIENT).phoneNumber(request.getPhoneNumber()).userName(request.getEmailAddress()).build();
        userRepository.save(newUser);
        Account newAccount = createAccount(request,newUser);
        return newAccount;
    }

    public Account createAccount(CreateAccountDTO request, User newUser){
        log.info("creating new account...");
        //Generate accountNumber
        String accountNumber = generateAccountNumber();
        Account newAccount = Account.builder().currencyCode(CurrencyCode.USD).accountBalance(BigDecimal.ZERO).previousBalance(BigDecimal.ZERO)
                .accountName(request.getName()).accountNumber(accountNumber).accountType(AccountType.PERSONAL_ACCOUNT)
                .accountHolder(newUser).build();
        return accountRepository.save(newAccount);
    }

    public Account createAccount(User existingUser){
        //Generate accountNumber
        String accountNumber = generateAccountNumber();
        Account newAccount = Account.builder().currencyCode(CurrencyCode.USD).accountBalance(BigDecimal.ZERO).previousBalance(BigDecimal.ZERO)
                .accountName(existingUser.getName()).accountNumber(accountNumber).accountType(AccountType.PERSONAL_ACCOUNT)
                .accountHolder(existingUser).build();
        return accountRepository.save(newAccount);
    }

    @Override
    public List<Account> fetchAll() {
        log.info("fetching all accounts...");
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
    public Account depositFund(CreateAccountDTO request) {
        return null;
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if(null == account){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid account number!");
        }
        return account;
    }

    @Override
    public Account fetchUserAccount(UUID userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found!"));
        Account account = accountRepository.findByAccountHolder(existingUser);
        if(null == account){
            createAccount(existingUser);
        }
        return account;
    }

    public String generateAccountNumber(){
        long sequenceId = LocalDateTime.now().toEpochSecond(ZoneOffset.MAX);
        return String.valueOf(sequenceId);
    }
}
