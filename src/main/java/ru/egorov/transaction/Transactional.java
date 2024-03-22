package ru.egorov.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Transactional {
    /**
     * @return тип операции
     */
    TypeOperation getTypeOperation();

    /**
     * @return баланс счета
     */
    BigDecimal getMoney();

    /**
     * @return дата транзакции
     */
    LocalDate getLocalDate();
}
