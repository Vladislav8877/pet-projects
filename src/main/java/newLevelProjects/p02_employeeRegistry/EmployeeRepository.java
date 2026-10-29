package newLevelProjects.p02_employeeRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    private final Map<Integer, Employee> database = new HashMap<>();
    private int sequenceId = 1;

    public Employee save(String name, String position, double salary) {
        Employee employee = new Employee(sequenceId, name, position, salary);
        database.put(sequenceId, employee);
        sequenceId++;
        return employee;
    }

    public List<Employee> findAll() {
        return new ArrayList<>(database.values());
    }

    public Employee findById(int id) {
        return database.get(id);
    }

    public boolean deleteById(int id) {
        return database.remove(id) != null;
        /*
       Map.remove(key) возвращает удалённое значение, если ключ существовал, или null, если ключа не было.
       Сравнение != null превращает это в boolean: true, если что-то реально удалили, false — если ключа и не было.
       Компактно и правильно, никакой правки не нужно.
        */
    }
}