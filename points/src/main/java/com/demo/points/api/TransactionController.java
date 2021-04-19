package com.demo.points.api;

import com.demo.points.model.Transaction;
import com.demo.points.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("api/v1/transaction")
@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public Map<String, Integer> handlePostMapping(@RequestBody Transaction transaction){
        if (transaction.getPayer() == null || transaction.getTimestamp() == null) {
            return spendPoints(transaction.getPoints());

        }
        else {
            addTransaction(transaction);
            return null;
        }
    }

    public void addTransaction(Transaction transaction){
        transactionService.addTransaction(transaction);
    }
    public Map<String, Integer> spendPoints(Integer points){
        return transactionService.spendPoints(points);
    }
    @GetMapping
    public Map<String, Integer> getTransactionStatus() {
        return transactionService.getTransactionsStatus();
    }
}
