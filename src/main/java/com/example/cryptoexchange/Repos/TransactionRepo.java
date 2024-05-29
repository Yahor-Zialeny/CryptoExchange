package com.example.cryptoexchange.Repos;

import com.example.cryptoexchange.Models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepo extends CrudRepository<Transaction, Long> { }
