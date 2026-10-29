package my_miniProjects.p02_bankService;

public class Account {
    private final String accountNumber; // номер счёта
    private String ownerName;
    private double balance;

    public Account(String accountNumber, String ownerName, double balance) {
        Validator.checkString(accountNumber, "номер счёта");
        Validator.checkString(ownerName, "имя владельца");
        Validator.checkNumber(balance, "баланс");

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void setOwnerName(String ownerName) {
        Validator.checkString(ownerName, "имя владельца");
        this.ownerName = ownerName;
    }

    public void deposit(double amount) {
        Validator.checkNumber(amount, "сумма пополнения");
        this.balance += amount;
    }

    public void withdraw(double amount) {
        Validator.checkNumber(amount, "сумма снятия");
        if (this.balance < amount) {
            throw new IllegalArgumentException("Ошибка: недостаточно средств на балансе!");
        }
        this.balance -= amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("%s || %s || %.2f", accountNumber, ownerName, balance);
    }
}