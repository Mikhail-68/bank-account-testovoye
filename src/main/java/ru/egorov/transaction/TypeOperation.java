package ru.egorov.transaction;

public enum TypeOperation {
    INCREMENT("Пополнение"),
    DECREMENT("Снятие");

    private String description;

    TypeOperation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
