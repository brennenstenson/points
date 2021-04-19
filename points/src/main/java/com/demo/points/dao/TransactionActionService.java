package com.demo.points.dao;

import com.demo.points.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository("Dao")
public class TransactionActionService implements TransactionDao {

    private static List<Transaction> DB = new ArrayList<>();
    private int pointsTracker;
    private Map<String, Integer> deductList = new HashMap<>();

    @Override
    public void insertTransaction(Transaction transaction) {
        DB.add(transaction);
        pointsTracker+=transaction.getPoints();
        deductList.put(transaction.getPayer(), 0);
        return;
    }
    @Override
    public Map<String, Integer> deductPoints(Integer points) {
        if (points > pointsTracker) throw new IllegalArgumentException("you can only deduct {} points."
                .format(String.valueOf(pointsTracker)));

        int counter = points;
        DB = DB.stream().sorted().collect(Collectors.toList());

        for(Transaction tx : DB) {
            if(counter>tx.getPoints()) {
                counter-=tx.getPoints();
                int newPoints = deductList.get(tx.getPayer()) - tx.getPoints();
                deductList.put(tx.getPayer(), newPoints);
                tx.setPoints(0);
            }else {
                int newPoints = deductList.get(tx.getPayer()) - counter;
                deductList.put(tx.getPayer(), newPoints);
                tx.setPoints(tx.getPoints() - counter);
                break;
            }
        }

        return deductList;
    }

    @Override
    public Map<String, Integer> fetchTransactionStatus() {
        Map<String, Integer> statusList = new HashMap<>();
        DB.forEach( tx -> {
            if (!statusList.containsKey(tx.getPayer())) {
                statusList.put(tx.getPayer(), tx.getPoints());
            }
            else {
                int newPoints = statusList.get(tx.getPayer()) + tx.getPoints();
                statusList.put(tx.getPayer(), newPoints);
            }
        });
        return statusList;
    }
}
