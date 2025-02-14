package ec.com.sofka.gateway;

import ec.com.sofka.account.Account;

import java.util.Optional;

public interface IAccountRepository {
    Account save(Account account);
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    Optional<Account> findByCustomerId(String customerId);

}
