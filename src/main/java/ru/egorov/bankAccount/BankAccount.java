package ru.egorov.bankAccount;

import ru.egorov.transaction.TransactionHistory;
import ru.egorov.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;

public abstract class BankAccount {
    protected BigDecimal money;
    protected TransactionHistory transactionHistory;

    /**
     * Увеличивает количество денег на счете
     *
     * @param money количество денег
     * @return количество прибавленных денег
     */
    public abstract BigDecimal incrementMoney(BigDecimal money);

    /**
     * Уменьшает количество денег на счете
     *
     * @param money количество денег
     * @return количество снятых денег со счета
     */
    public abstract BigDecimal decrementMoney(BigDecimal money);

    /**
     * @return количество денег на счете
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * @return история транзакций
     */
    public List<Transactional> getTransactionList() {
        return transactionHistory.getTransactionList();
    }
}
