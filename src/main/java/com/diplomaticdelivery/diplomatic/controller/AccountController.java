package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.requestDto.AccountDTO;
import com.diplomaticdelivery.diplomatic.requestDto.TransactionDTO;
import com.diplomaticdelivery.diplomatic.service.AccountService;
import com.diplomaticdelivery.diplomatic.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDTO request) {
        Account response = accountService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<Account>> fetchAll() {
        List<Account> response = accountService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
