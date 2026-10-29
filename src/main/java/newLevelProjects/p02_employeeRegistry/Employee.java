package newLevelProjects.p02_employeeRegistry;

public class Employee {
    private final int id;
    private String name;
    private String position;
    private double salary;

    public Employee(int id, String name, String position, double salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void setSalary(double salary) {
        Validator.checkAmount(salary,"зарплата");
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("%d. %s || %s || %.2f", id, name, position, salary);
    }
}