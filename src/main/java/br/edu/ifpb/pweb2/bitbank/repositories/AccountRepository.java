package br.edu.ifpb.pweb2.bitbank.repositories;

import br.edu.ifpb.pweb2.bitbank.models.Account;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AccountRepository {
    private final Map<Integer, Account> repository = new HashMap<>();

    public Account findById(Integer id) {
        return repository.get(id);
    }

    public Account save(Account account) {
        Integer id;
        id = (account.getId() == null) ? this.getMaxId() + 1 : account.getId();
        account.setId(id);
        repository.put(id, account);
        return account;
    }

    public List<Account> findAll() {
        return new ArrayList<>(repository.values());
    }

    public Integer getMaxId() {
        List<Account> accounts = findAll();

        if (accounts == null || accounts.isEmpty())
            return 1;

        Account accountMaxId = accounts
                .stream()
                .max(Comparator.comparing(Account::getId))
                .orElseThrow(NoSuchElementException::new);

        return accountMaxId.getId() == null ? 1 : accountMaxId.getId() + 1;
    }
}
