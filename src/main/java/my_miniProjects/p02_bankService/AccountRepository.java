package my_miniProjects.p02_bankService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {
    private final Map<String, Account> accounts = new HashMap<>();
    private int sequence = 1;

    public Account save(String ownerName, double initialBalance) {
        String accountNumber = "ACC-" + sequence++;
        Account account = new Account(accountNumber, ownerName, initialBalance);
        accounts.put(accountNumber, account);
        return account;
    }

    public Account findByAccountNumber(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public List<Account> findAllAccounts() {
        return new ArrayList<>(accounts.values());
    }
}