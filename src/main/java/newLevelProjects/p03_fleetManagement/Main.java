package newLevelProjects.p03_fleetManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleRepository repository = new VehicleRepository();
        VehicleService service = new VehicleService(repository);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в систему учёта автопарка!");

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. Добавить машину");
            System.out.println("2. Показать все машины");
            System.out.println("3. Добавить пробег");
            System.out.println("4. Удалить машину");
            System.out.println("5. Найти по модели");
            System.out.println("0. Выход");
            System.out.println("=================================");
            System.out.print("Выберите действие: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Гос. номер: ");
                        String plateNumber = scanner.nextLine();
                        System.out.print("Модель: ");
                        String model = scanner.nextLine();
                        System.out.print("Текущий пробег (км): ");
                        double mileage = Double.parseDouble(scanner.nextLine());
                        service.addVehicle(plateNumber, model, mileage);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: пробег должен быть числом!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    service.showAllVehicles();
                    break;
                case "3":
                    try {
                        System.out.print("ID машины: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Сколько км добавить: ");
                        double km = Double.parseDouble(scanner.nextLine());
                        service.addMileage(id, km);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: введите корректное число!");
                    } catch (IllegalArgumentException | ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        System.out.print("ID машины: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        service.removeVehicle(id);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: ID должен быть числом!");
                    } catch (ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    try {
                        System.out.print("Модель: ");
                        String model = scanner.nextLine();
                        service.findByModel(model);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "0":
                    System.out.println("До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод!");
            }
        }
    }
}