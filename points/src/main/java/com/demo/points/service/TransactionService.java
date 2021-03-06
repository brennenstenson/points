package com.demo.points.service;

import com.demo.points.dao.TransactionDao;
import com.demo.points.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TransactionService {

    private final TransactionDao transactionDao;

    @Autowired
    public TransactionService(@Qualifier("Dao") TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }
    public void addTransaction(Transaction transaction) {
        transactionDao.insertTransaction(transaction);
        return;
    }

    public Map<String, Integer> spendPoints(Integer points) {
        return transactionDao.deductPoints(points);
    }

    public Map<String, Integer> getTransactionsStatus() {
        return transactionDao.fetchTransactionStatus();
    }
}
