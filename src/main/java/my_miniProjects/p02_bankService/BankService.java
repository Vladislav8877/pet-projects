package my_miniProjects.p02_bankService;

import java.util.List;

public class BankService {
    private final AccountRepository accountRepository;

    public BankService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String ownerName, double initialBalance) {
        Validator.checkString(ownerName,"имя владельца");
        Validator.checkNumber(initialBalance,"баланс");

        Account newAccount = accountRepository.save(ownerName, initialBalance);
        System.out.println("Счёт успешно создан! Ваш номер счёта: " + newAccount.getAccountNumber());
    }

    public void deposit(String accountNumber, double amount) {
        Validator.checkString(accountNumber,"номер счёта");
        Validator.checkNumber(amount,"сумма пополнения");

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new ItemNotFoundException("Счёт: " +  accountNumber + " не был найден!");
        }
        account.deposit(amount);
        System.out.println("Сумма пополнения: " + amount + " || Текущий баланс: " + account.getBalance());
    }

    public void withdraw(String accountNumber, double amount) {
        Validator.checkString(accountNumber,"номер счёта");
        Validator.checkNumber(amount,"сумма снятия");

        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new ItemNotFoundException("Счёт: " +  accountNumber + " не был найден!");
        }
        account.withdraw(amount);
        System.out.println("Сумма снятия: " + amount + " || Текущий баланс: " + account.getBalance());
    }

    public void transfer(String fromNumber, String toNumber, double amount) {
        Validator.checkString(fromNumber,"номер счёта");
        Validator.checkString(toNumber,"номер счёта");
        Validator.checkNumber(amount,"сумма перевода");

        Account fromAccount = accountRepository.findByAccountNumber(fromNumber);
        Account toAccount = accountRepository.findByAccountNumber(toNumber);
        if (fromAccount == null) {
            throw new ItemNotFoundException("Счёт: " +  fromNumber + " не был найден!");
        }
        if (toAccount == null) {
            throw new ItemNotFoundException("Счёт: " +  toNumber + " не был найден!");
        }
        if (fromNumber.equals(toNumber)) {
            System.err.println("Невозможно произвести перевод самому себе!");
            return;
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println("Перевод успешно произведен");
    }

    public void showAllAccounts() {
        //accountRepository.findAllAccounts().forEach(System.out::println);
        List<Account> accounts = accountRepository.findAllAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Ошибка: список пуст!");
            return;
        }

        System.out.println("Список счетов: ");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}