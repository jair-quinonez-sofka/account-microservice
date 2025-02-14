package ec.com.sofka.mapper;

import ec.com.sofka.account.Account;
import ec.com.sofka.data.AccountEntity;

public class AccountEntityMapper {
    public static AccountEntity toAccountEntity(Account account) {
        return new AccountEntity(
                account.getId(),
                account.getAccountNumber(),
                account.getAccountType(),
                account.getInitialBalance(),
                account.isStatus(),
                account.getCustomerId()
        );

    }

    public static Account toAccount(AccountEntity accountEntity) {
        return new Account(
                accountEntity.getId(),
                accountEntity.getAccountNumber(),
                accountEntity.getAccountType(),
                accountEntity.getInitialBalance(),
                accountEntity.isStatus(),
                accountEntity.getCustomerId()
        );
    }
}
