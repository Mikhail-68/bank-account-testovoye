package ru.egorov.bankAccount;

import ru.egorov.transaction.TypeOperation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MyBankAccount extends BankAccount {

    @Override
    public BigDecimal incrementMoney(BigDecimal additionMoney) {
        additionMoney = roundMoney(additionMoney);
        money = money.add(additionMoney);
        transactionHistory.addNewTransaction(TypeOperation.INCREMENT, additionMoney);
        return additionMoney;
    }

    @Override
    public BigDecimal decrementMoney(BigDecimal decreaseMoney) {
        decreaseMoney = roundMoney(decreaseMoney);
        money = money.subtract(decreaseMoney);
        transactionHistory.addNewTransaction(TypeOperation.DECREMENT, decreaseMoney);
        return decreaseMoney;
    }

    private BigDecimal roundMoney(BigDecimal money) {
        return money.setScale(2, RoundingMode.HALF_EVEN);
    }
}
