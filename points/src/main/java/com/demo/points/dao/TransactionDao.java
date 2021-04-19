package com.demo.points.dao;

import com.demo.points.model.Transaction;
import java.util.Date;
import java.util.List;

public interface TransactionDao {

    void insertTransaction(String payer, Integer points, Date timestamp);

    List<Transaction> deductPoints(Integer points);

    List<Transaction> fetchTransactionStatus();
}
