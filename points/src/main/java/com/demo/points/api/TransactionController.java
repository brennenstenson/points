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

    @PutMapping
    public void addTransaction(@RequestBody String payer, Integer points, Date timestamp){
        transactionService.addTransaction(payer, points, timestamp);
    }

    @PostMapping
    public List<Transaction> spendPoints(@RequestBody Integer points){
        return transactionService.spendPoints(points);
    }
    @GetMapping
    public List<Transaction> getTransactionStatus() {
        return transactionService.getTransactionsStatus();
    }
}
