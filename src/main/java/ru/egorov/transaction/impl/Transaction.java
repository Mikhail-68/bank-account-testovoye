package ru.egorov.transaction.impl;

import ru.egorov.transaction.Transactional;
import ru.egorov.transaction.TypeOperation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction implements Transactional {
    private TypeOperation typeOperation;
    private BigDecimal money;
    private LocalDate localDate;

    public Transaction(TypeOperation typeOperation, BigDecimal money, LocalDate localDate) {
        this.typeOperation = typeOperation;
        this.money = money;
        this.localDate = localDate;
    }

    @Override
    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
    }

    @Override
    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
