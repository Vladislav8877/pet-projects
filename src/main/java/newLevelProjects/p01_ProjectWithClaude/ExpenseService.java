package newLevelProjects.p01_ProjectWithClaude;

import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public void addExpense(String description, double amount, String category) {
        Validator.checkString(description,"описание");
        Validator.checkAmount(amount,"сумма");
        Validator.checkString(category,"категория");

        Expense created = repository.save(description, amount, category);
        System.out.println("Расход добавлен: "+created);
    }

    public void showAllExpenses() {
        List<Expense> expenses = repository.findAll();

        if (expenses.isEmpty()) {
            System.out.println("Список расходов пуст!");
            return;
        }

        System.out.println("Все расходы:");
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public void deleteExpense(int id) {
        boolean isDeleted = repository.deleteById(id);
        if (isDeleted) {
            System.out.println("Расход с ID: " + id +" удалён.");
        } else {
            System.out.println("Ошибка: расход с ID: " + id + " не найден");
        }
    }

    public void byCategory(String category) {
        Validator.checkString(category,"категория");

        double total = 0;
        boolean found = false;

        for (Expense expense : repository.findAll()) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
                found = true;
            }
        }

        if (!found) {
            System.out.println("По категории \"" + category +"\" расходов не найдено");
        } else {
            System.out.printf("Итого по категории \"%s\": %.2f%n", category, total);
        }
    }
}