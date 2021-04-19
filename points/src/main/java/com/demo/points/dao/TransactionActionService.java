package com.demo.points.dao;

import com.demo.points.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository("Dao")
public class TransactionActionService implements TransactionDao {

    private static List<Transaction> DB = new ArrayList<>();

    @Override
    public void insertTransaction(String payer, Integer points, Date timestamp) {
        DB.add(new Transaction(payer, points, timestamp));
        return;
    }

    public List<Transaction> deductPoints(Integer points) {
        //insert DB logic here
        return DB;
    }
}
