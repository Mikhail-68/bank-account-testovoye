package ru.egorov.transaction.impl;

import ru.egorov.transaction.TransactionHistory;
import ru.egorov.transaction.Transactional;
import ru.egorov.transaction.TypeOperation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistoryImpl implements TransactionHistory {
    private List<Transactional> transactionList;

    public TransactionHistoryImpl() {
        transactionList = new ArrayList<>();
    }

    @Override
    public List<Transactional> getTransactionList() {
        return new ArrayList<>(transactionList);
    }

    @Override
    public void addNewTransaction(TypeOperation typeOperation, BigDecimal money) {
        transactionList.add(new Transaction(typeOperation, money, LocalDate.now()));
    }
}
