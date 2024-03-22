package ru.egorov.transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionHistory {
    /**
     * @return лист транзакций
     */
    List<Transactional> getTransactionList();

    /**
     * Создает новую транзакцию
     *
     * @param typeOperation тип операции
     * @param money         размер денег транзакции
     */
    void addNewTransaction(TypeOperation typeOperation, BigDecimal money);
}
