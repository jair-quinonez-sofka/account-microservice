package ec.com.sofka.usecases.account;

import ec.com.sofka.account.Account;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.IAccountRepository;
import ec.com.sofka.gateway.IBusMessage;

import java.util.Optional;

public class CreateAccountUseCase {
    private final IAccountRepository accountRepository;
    private final IBusMessage busMessage;

    public CreateAccountUseCase(IAccountRepository accountRepository, IBusMessage busMessage) {
        this.accountRepository = accountRepository;
        this.busMessage = busMessage;
    }


    public Account apply(Account account, String identification) {
        Optional<Account> accountFound = accountRepository.findAccountByAccountNumber(account.getAccountNumber());
        Object response;
        String customerId;

        if (accountFound.isPresent()) {
            throw new RuntimeException("Error creating account: Account already exists");
        }

        response  = busMessage.sendMessage(new CustomerInfoRequestRecord(identification, false));
        customerId = (String) response;

        if (customerId == null  ||  customerId.isEmpty()) {
            throw new RuntimeException("Error creating account: Customer not Found");
        }
        account.setCustomerId(customerId);

        return accountRepository.save(account);
    }
}
