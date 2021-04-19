package com.demo.points.dao;

import com.demo.points.model.Transaction;
import java.util.Date;

public interface TransactionDao {

    int insertTransaction(String payer, Integer points, Date timestamp);

    default int addTransaction(Transaction transaction) {
        return 0;
    }

    default int spendPoints(Integer points) {
        return 0;
    }
}
