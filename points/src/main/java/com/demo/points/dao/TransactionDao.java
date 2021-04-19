package com.demo.points.dao;

import com.demo.points.model.Transaction;
import java.util.Date;
import java.util.List;

public interface TransactionDao {

    void insertTransaction(Transaction transaction);

    List<Transaction> deductPoints(Integer points);

    List<Transaction> fetchTransactionStatus();
}
