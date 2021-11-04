package com.diplomaticdelivery.diplomatic.controller;

import com.diplomaticdelivery.diplomatic.model.Account;
import com.diplomaticdelivery.diplomatic.request.CreateAccountDTO;
import com.diplomaticdelivery.diplomatic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vi/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody CreateAccountDTO request) {
        Account response = accountService.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Account> fetchAll(@PathVariable("userId") UUID userId) {
        return new ResponseEntity<>(accountService.fetchUserAccount(userId), HttpStatus.OK);
    }

    @GetMapping("/list-all")
    public ResponseEntity<List<Account>> fetchAll() {
        List<Account> response = accountService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
