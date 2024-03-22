package ru.egorov.actionRepository;

import ru.egorov.bankAccount.BankAccount;
import ru.egorov.transaction.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Consumer;

public enum ActionRepository implements Consumer<BankAccount> {
    INCREMENT_MONEY("Пополнить счет") {
        @Override
        public void accept(BankAccount bankAccount) {
            System.out.println("Введите сумму для пополнения: ");
            BigDecimal money = bankAccount.incrementMoney(enteringNumber());
            System.out.println("Счет успешно пополнен на " + money + " руб.");
        }
    },
    DECREMENT_MONEY("Снять деньги") {
        @Override
        public void accept(BankAccount bankAccount) {
            System.out.println("Введите сумму для снятия: ");
            BigDecimal money = bankAccount.decrementMoney(enteringNumber());
            System.out.println("Со счета снято " + money + " руб. Остаток: " + bankAccount.getMoney() + " руб.");
        }
    },
    CHECK_MONEY("Проверить баланс") {
        @Override
        public void accept(BankAccount bankAccount) {
            System.out.println("Баланс на счете: " + bankAccount.getMoney() + " руб.");
        }
    },
    GET_HISTORY_TRANSACTION("История транзакций") {
        @Override
        public void accept(BankAccount bankAccount) {
            List<Transactional> transactionList = bankAccount.getTransactionList();

            System.out.println("История транзакций:");

            if (transactionList.isEmpty()) {
                System.out.println("Пусто");
                return;
            }

            transactionList.forEach((transactional) -> System.out.printf("- %s: %s руб. (%s)\n",
                    transactional.getTypeOperation().getDescription(),
                    transactional.getMoney(), transactional.getLocalDate()));
        }
    };

    private final String description;

    ActionRepository(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    BigDecimal enteringNumber() {
        Scanner sc = new Scanner(System.in);
        double number;
        while (true) {
            try {
                number = sc.nextDouble();
                if (number <= 0) throw new IllegalArgumentException();
                break;
            } catch (NoSuchElementException ex) {
                System.out.println("Введены неверные данные. Введите еще раз:");
                sc.nextLine();
            } catch (IllegalArgumentException ex) {
                System.out.println("Сумма платежа должна быть больше 0. Введите еще раз:");
            }
        }
        return BigDecimal.valueOf(number);
    }
}
