package ec.com.sofka.gateway;

import ec.com.sofka.account.Account;

public interface IAccountRepository {
    Account save(Account account);
}
