package ec.com.sofka.adapters;

import ec.com.sofka.account.Account;
import ec.com.sofka.config.IAccountJpaRepository;
import ec.com.sofka.gateway.IAccountRepository;
import ec.com.sofka.mapper.AccountEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AccountAdapter implements IAccountRepository {
    private final IAccountJpaRepository accountJpaRepository;

    public AccountAdapter(IAccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public Account save(Account account) {
        return AccountEntityMapper.toAccount(accountJpaRepository.save(AccountEntityMapper.toAccountEntity(account)));
    }
}
