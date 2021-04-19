package com.demo.points.api;

import com.demo.points.model.Transaction;
import com.demo.points.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/v1/transaction")
@RestController
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public void handlePostMapping(@RequestBody Transaction transaction){
        if (transaction.getPayer() == null || transaction.getTimestamp() == null) {
            spendPoints(transaction.getPoints());
        }
        else addTransaction(transaction);
    }

    public void addTransaction(Transaction transaction){
        transactionService.addTransaction(transaction);
    }
    public List<Transaction> spendPoints(Integer points){
        return transactionService.spendPoints(points);
    }
    @GetMapping
    public List<Transaction> getTransactionStatus() {
        return transactionService.getTransactionsStatus();
    }
}
