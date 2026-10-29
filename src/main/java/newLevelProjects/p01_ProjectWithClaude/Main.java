package newLevelProjects.p01_ProjectWithClaude;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseRepository repository = new ExpenseRepository();
        ExpenseService service = new ExpenseService(repository);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Expense Tracker!");

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. Добавить расход");
            System.out.println("2. Показать все расходы");
            System.out.println("3. Удалить расход");
            System.out.println("4. Сумма расходов по категории");
            System.out.println("0. Выход");
            System.out.println("=================================");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Описание: ");
                        String description = scanner.nextLine();
                        System.out.print("Сумма: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        System.out.print("категория: ");
                        String category = scanner.nextLine();
                        service.addExpense(description, amount, category);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: сумма должна быть числом!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    service.showAllExpenses();
                    break;
                case "3":
                    try {
                        System.out.print("Введите ID расхода: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        service.deleteExpense(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: ID должно быть числом!");
                    }
                    break;
                case "4":
                    try {
                        System.out.print("Введите категорию: ");
                        String category = scanner.nextLine();
                        service.byCategory(category);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("До свидания");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }
}