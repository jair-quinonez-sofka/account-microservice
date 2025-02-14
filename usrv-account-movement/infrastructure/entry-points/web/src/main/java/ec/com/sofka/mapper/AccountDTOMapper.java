package ec.com.sofka.mapper;

import ec.com.sofka.account.Account;
import ec.com.sofka.data.AccountDTO;

public class AccountDTOMapper {
    public static AccountDTO toAccountDTO(Account account) {
        return  new AccountDTO(
                account.getAccountNumber(),
                account.getAccountType(),
                account.getInitialBalance(),
                "",
                account.isStatus()

        );
    }

    public static Account toAccount(AccountDTO accountDTO) {
        return new Account(
                null,
                accountDTO.getAccountNumber(),
                accountDTO.getAccountType(),
                accountDTO.getInitialBalance(),
                accountDTO.isStatus(),
                null
        );
    }
}
