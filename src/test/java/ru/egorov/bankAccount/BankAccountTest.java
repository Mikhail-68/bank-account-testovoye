package ru.egorov.bankAccount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void init() {
        bankAccount = new MyBankAccount();
    }

    @Nested
    class IncrementMoneyTest {
        @Test
        public void checkIncrementMoneyRoundUp() {
            bankAccount.incrementMoney(BigDecimal.valueOf(1.12545));
            Assertions.assertEquals(1.13, bankAccount.getMoney().doubleValue());
        }

        @Test
        public void checkIncrementMoneyRoundDown() {
            bankAccount.incrementMoney(BigDecimal.valueOf(1.12445));
            Assertions.assertEquals(1.12, bankAccount.getMoney().doubleValue());
        }
    }

    @Nested
    class DecrementMoneyTest {
        @Test
        public void checkDecrementMoneyRoundUp() {
            bankAccount.decrementMoney(BigDecimal.valueOf(1.12545));
            Assertions.assertEquals(-1.13, bankAccount.getMoney().doubleValue());
        }

        @Test
        public void checkDecrementMoneyRoundDown() {
            bankAccount.decrementMoney(BigDecimal.valueOf(1.12445));
            Assertions.assertEquals(-1.12, bankAccount.getMoney().doubleValue());
        }
    }
}
