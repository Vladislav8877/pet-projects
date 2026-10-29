package newLevelProjects.p01_ProjectWithClaude;

import java.time.LocalDateTime;

public class Expense { // трекер расходов
    private final int id;
    private String description;
    private double amount;
    private String category;
    private final LocalDateTime createAt;

    public Expense(int id, String description, double amount, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.createAt = LocalDateTime.now();
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("%d. %s || %.2f || %s (Добавлено: %s)", id, description, amount, category, createAt);
    }
}