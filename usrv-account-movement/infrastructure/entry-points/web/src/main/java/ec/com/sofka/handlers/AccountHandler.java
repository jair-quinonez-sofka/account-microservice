package ec.com.sofka.handlers;

import ec.com.sofka.data.AccountDTO;
import ec.com.sofka.mapper.AccountDTOMapper;
import ec.com.sofka.usecases.CreateAccountUseCase;
import org.springframework.stereotype.Component;

@Component
public class AccountHandler  {
    private final CreateAccountUseCase createAccountUseCase;


    public AccountHandler(CreateAccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        return AccountDTOMapper.toAccountDTO(
                createAccountUseCase.apply(AccountDTOMapper.toAccount(accountDTO), accountDTO.getClientIdentification())
        );
    }
}
