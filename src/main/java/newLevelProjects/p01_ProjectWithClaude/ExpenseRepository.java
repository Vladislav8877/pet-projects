package newLevelProjects.p01_ProjectWithClaude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseRepository {
    private final Map<Integer, Expense> database = new HashMap<>();
    private int sequenceId = 1;

    public Expense save(String description, double amount, String category) {
        Expense expense = new Expense(sequenceId, description, amount, category);
        database.put(sequenceId, expense);
        sequenceId++;
        return expense;
    }

    public List<Expense> findAll() {
        return new ArrayList<>(database.values());
    }

    public boolean deleteById(int id) {
        return database.remove(id) != null;
    }
}