package newLevelProjects.p02_employeeRegistry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);
        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в Employee App!");

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. Добавить сотрудника");
            System.out.println("2. Показать всех сотрудников");
            System.out.println("3. Увеличить зарплату сотруднику");
            System.out.println("4. Удалить сотрудника из базы данных");
            System.out.println("5. Найти сотрудника по должности");
            System.out.println("0. Выход");
            System.out.println("=================================");
            System.out.print("Выберите действие: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Введите имя: ");
                        String name = sc.nextLine();
                        System.out.println("Введите должность: ");
                        String position = sc.nextLine();
                        System.out.println("Введите зарплату: ");
                        double salary = Double.parseDouble(sc.nextLine());
                        service.hireEmployee(name,position,salary);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: поле \"зарплата\" должно содержать цифры!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    service.showAllEmployees();
                    break;
                case "3":
                    try {
                        System.out.print("Введите ID сотрудника: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Введите % поднятие зарплаты: ");
                        double percent = Double.parseDouble(sc.nextLine());
                        service.raiseSalary(id, percent);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: поле должно содержать цифры");
                    } catch (ItemNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        System.out.print("Введите ID сторудника: ");
                        int id = Integer.parseInt(sc.nextLine());
                        service.fireEmployee(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: поле должно содержать цифры");
                    } catch (ItemNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    try {
                        System.out.print("Введите должность сторудника: ");
                        String position = sc.nextLine();
                        service.findByPosition(position);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("До свидания!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод данных!");
            }
        }
    }
}