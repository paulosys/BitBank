package br.edu.ifpb.pweb2.bitbank.repositories;

import br.edu.ifpb.pweb2.bitbank.models.Customer;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomerRepository {
    private final Map<Integer, Customer> repository = new HashMap<>();

    public Customer findById(Integer id) {
        return repository.get(id);
    }

    public void save(Customer customer) {
        Integer id;
        id = (customer.getId() == null) ? this.getMaxId() + 1 : customer.getId();
        customer.setId(id);
        repository.put(id, customer);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(repository.values());
    }

    public Integer getMaxId() {
        List<Customer> accounts = findAll();

        if (accounts == null || accounts.isEmpty())
            return 1;

        Customer accountMaxId = accounts
                .stream()
                .max(Comparator.comparing(Customer::getId))
                .orElseThrow(NoSuchElementException::new);

        return accountMaxId.getId() == null ? 1 : accountMaxId.getId() + 1;
    }
}
