package com.demo.points.dao;

import com.demo.points.model.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionDao {

    void insertTransaction(Transaction transaction);

    Map<String, Integer> deductPoints(Integer points);

    Map<String, Integer> fetchTransactionStatus();
}
