package ru.egorov;

import ru.egorov.actionRepository.ActionRepository;
import ru.egorov.bankAccount.BankAccount;
import ru.egorov.bankAccount.MyBankAccount;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        BankAccount bankAccount = new MyBankAccount();
        int countActions = ActionRepository.values().length;

        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в \"Банковский счет\"");
        System.out.println("Возможные действия:");
        for (int i = 0; i < countActions; i++) {
            System.out.println((i + 1) + ". " + ActionRepository.values()[i].getDescription());
        }
        System.out.println((countActions + 1) + ". Выход");

        while (true) {
            System.out.println("\nВыберите действие и введите номер:");
            int actionNum;

            actionNum = enteredActionNum(countActions);
            if (actionNum == -1) continue;

            if (actionNum - 1 == countActions) {
                System.out.println("До новых встреч!");
                break;
            }

            ActionRepository.values()[actionNum - 1].accept(bankAccount);
        }
    }

    private static int enteredActionNum(int countActions) {
        Scanner sc = new Scanner(System.in);
        int actionNum;
        try {
            actionNum = sc.nextInt();
            if (actionNum > countActions + 1 || actionNum <= 0) throw new IndexOutOfBoundsException();
        } catch (NoSuchElementException ex) {
            System.out.println("Введены неверные данные, попробуйте еще раз...");
            sc.nextLine();
            return -1;
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Введен некорректный номер действия. Корректный диапазон: от 1 до " + (countActions + 1));
            return -1;
        }
        return actionNum;
    }
}