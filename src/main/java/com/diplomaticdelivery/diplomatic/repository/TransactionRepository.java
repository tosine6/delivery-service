package com.diplomaticdelivery.diplomatic.repository;

import com.diplomaticdelivery.diplomatic.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    List<Transaction> findBySenderAccountNumber(String senderAccountNumber);

}
