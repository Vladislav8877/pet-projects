package my_miniProjects.p01_firstStep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. СБОРКА ПРИЛОЖЕНИЯ (Внедрение зависимостей)
        // Создаем хранилище
        TaskRepository repository = new TaskRepository();
        // Передаем хранилище внутрь сервиса
        TaskService service = new TaskService(repository);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в Task Tracker!");

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. ➕ Добавить новую задачу");
            System.out.println("2. 📋 Показать все задачи");
            System.out.println("3. ✅ Отметить задачу как выполненную");
            System.out.println("4. 🗑️ Удалить задачу");
            System.out.println("0. 🚪 Выход");
            System.out.println("=================================");
            System.out.print("👉 Выберите действие (введите цифру): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice) {
                case 1:
                    System.out.print("Введите текст задачи: ");
                    String title = scanner.nextLine();
                    service.addTask(title);
                    break;
                case 2:
                    service.showAllTasks();
                    break;
                case 3:
                    System.out.print("Введите ID задачи для выполнения: ");
                    int completeID = Integer.parseInt(scanner.nextLine());
                    service.completeTask(completeID);
                    break;
                case 4:
                    System.out.print("Введите ID задачи для удаления: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    service.deleteTask(deleteId);
                    break;
                case 0:
                    System.out.println("До свидания! Продуктивного дня!");
                    scanner.close();
                    return;
                default:
                    System.out.println("❌ Ошибка: Неизвестная команда. Попробуйте еще раз.");
            }
        }
    }
}