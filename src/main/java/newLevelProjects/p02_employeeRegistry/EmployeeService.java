package newLevelProjects.p02_employeeRegistry;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void hireEmployee(String name, String position, double salary) {
        Validator.checkString(name, "имя");
        Validator.checkString(position,"должность");
        Validator.checkAmount(salary,"зарплата");

        Employee created = repository.save(name, position, salary);
        System.out.println("Новый сотрудник добавлен в базу: " + created);
    }

    public void showAllEmployees() {
        List<Employee> employees = repository.findAll();

        if (employees.isEmpty()) {
            System.out.println("Список сотрудников пуст!");
            return;
        }

        System.out.println("Список сотрудников:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public void raiseSalary(int id, double percent) {
        Validator.checkAmount(percent,"% увелечения зарплаты");

        Employee employee = repository.findById(id);
        if (employee == null) {
            throw new ItemNotFoundException("Ошибка: сотрудник с ID: " + id + " не найден!");
        }

        double newSalary = employee.getSalary() + employee.getSalary() * percent / 100;
        employee.setSalary(newSalary);
        System.out.printf("Новая зарплата у %s: %.2f%n", employee.getName(), newSalary);
    }

    public void fireEmployee(int id) {
        boolean isDeleted = repository.deleteById(id);

        if (isDeleted) {
            System.out.println("Сотрудник с ID: " + id + " удален из базы!");
        } else {
            throw new ItemNotFoundException("Ошибка: сотрудник с ID " + id + " не найден!");
        }
    }

    public void findByPosition(String position) {
        Validator.checkString(position, "должность");

        List<Employee> employees = repository.findAll();
        boolean found = false;

        for (Employee e : employees) {
            if (e.getPosition().equalsIgnoreCase(position)) {
                System.out.println(e);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Сотрудников с должностью \"" + position + "\" не найдено.");
        }
    }
}