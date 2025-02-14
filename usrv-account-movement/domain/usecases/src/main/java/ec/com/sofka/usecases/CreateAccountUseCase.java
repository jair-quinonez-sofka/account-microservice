package ec.com.sofka.usecases;

import ec.com.sofka.account.Account;
import ec.com.sofka.gateway.IAccountRepository;
import ec.com.sofka.gateway.IBusMessage;

public class CreateAccountUseCase {
    private final IAccountRepository accountRepository;
    private final IBusMessage busMessage;

    public CreateAccountUseCase(IAccountRepository accountRepository, IBusMessage busMessage) {
        this.accountRepository = accountRepository;
        this.busMessage = busMessage;
    }


    public Account apply(Account account, String identification) {
        String customerId  = busMessage.sendMessage(identification);
        if (customerId == null  ||  customerId.isEmpty()) {
            throw new RuntimeException("Error creating account: Customer not Found");
        }
        account.setCustomerId(customerId);

        return accountRepository.save(account);
    }
}
