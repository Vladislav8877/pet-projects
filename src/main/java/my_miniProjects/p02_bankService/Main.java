package my_miniProjects.p02_bankService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountRepository repository = new AccountRepository();
        BankService service = new BankService(repository);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в банковскую систему");

        while (true) {
            System.out.println("\n=================================");
            System.out.println("1. Открыть новый счёт");
            System.out.println("2. Пополнить счёт");
            System.out.println("3. Снять деньги");
            System.out.println("4. Перевести деньги");
            System.out.println("5. Показать все счета");
            System.out.println("0. Выход");
            System.out.println("=================================");
            System.out.print("👉 Выберите действие (введите цифру): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Введите имя: ");
                        String name = scanner.nextLine();
                        System.out.print("Введите баланс: ");
                        double balance = Double.parseDouble(scanner.nextLine());
                        service.createAccount(name, balance);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: баланс должен быть цифрой!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    try {
                        System.out.print("Введите номер счёта: ");
                        String accountDeposit = scanner.nextLine();
                        System.out.print("Введите сумму пополнения: ");
                        double amountDeposit = Double.parseDouble(scanner.nextLine());
                        service.deposit(accountDeposit, amountDeposit);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: сумма пополнения должна быть цифрой!");
                    } catch (IllegalArgumentException | ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        System.out.print("Введите номер счёта: ");
                        String accountWithdraw = scanner.nextLine();
                        System.out.print("Введите сумму снятия: ");
                        double amountWithdraw = Double.parseDouble(scanner.nextLine());
                        service.withdraw(accountWithdraw, amountWithdraw);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: сумма снятия должна быть цифрой!");
                    } catch (IllegalArgumentException | ItemNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    try {
                        System.out.print("Введите номер счёта отправителя: ");
                        String fromNumber = scanner.nextLine();
                        System.out.print("Введите номер счёта получателя: ");
                        String toNumber = scanner.nextLine();
                        System.out.print("Введите сумму перевода: ");
                        double amount = Double.parseDouble(scanner.nextLine());
                        service.transfer(fromNumber, toNumber, amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибка: сумма перевода должно быть числом!");
                    } catch (ItemNotFoundException | IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "5":
                    service.showAllAccounts();
                    break;
                case "0":
                    System.out.println("До свидания!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод! Попробуйте снова!");
            }
        }
    }
}