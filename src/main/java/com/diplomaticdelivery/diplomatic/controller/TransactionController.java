package com.diplomaticdelivery.diplomatic.controller;


import com.diplomaticdelivery.diplomatic.model.Transaction;
import com.diplomaticdelivery.diplomatic.requestDto.TransactionDTO;
import com.diplomaticdelivery.diplomatic.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/save")
    public ResponseEntity<Transaction> saveTransaction(@RequestBody TransactionDTO request) {
        Transaction response = transactionService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("list-all")
    public ResponseEntity<List<Transaction>> createConsignment() {
        List<Transaction> response = transactionService.fetchAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
