package br.edu.ifpb.pweb2.bitbank.service;

import br.edu.ifpb.pweb2.bitbank.models.Account;
import br.edu.ifpb.pweb2.bitbank.models.Customer;
import br.edu.ifpb.pweb2.bitbank.repositories.AccountRepository;
import br.edu.ifpb.pweb2.bitbank.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountService implements Service<Account, Integer>{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account account) {
        Customer customer = customerRepository.findById(account.getCustomer().getId());
        account.setCustomer(customer);
        return accountRepository.save(account);
    }
}
