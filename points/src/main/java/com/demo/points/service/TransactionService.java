package com.demo.points.service;

import com.demo.points.dao.TransactionDao;
import com.demo.points.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    private final TransactionDao transactionDao;

    @Autowired
    public TransactionService(@Qualifier("Dao") TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }
    public int addTransaction(String payer, Integer points, Date timestamp) {
        return transactionDao.insertTransaction(payer, points, timestamp);
    }

}
