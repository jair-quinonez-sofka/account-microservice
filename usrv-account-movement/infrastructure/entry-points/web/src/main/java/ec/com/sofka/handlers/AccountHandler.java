package ec.com.sofka.handlers;

import ec.com.sofka.data.AccountDTO;
import ec.com.sofka.data.AccountStatementResponseDTO;
import ec.com.sofka.mapper.AccountDTOMapper;
import ec.com.sofka.usecases.account.CreateAccountUseCase;
import ec.com.sofka.usecases.account.GetAccountStatementUseCase;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountHandler  {
    private final CreateAccountUseCase createAccountUseCase;
    private final GetAccountStatementUseCase getAccountStatementUseCase;


    public AccountHandler(CreateAccountUseCase createAccountUseCase, GetAccountStatementUseCase getAccountStatementUseCase) {
        this.createAccountUseCase = createAccountUseCase;
        this.getAccountStatementUseCase = getAccountStatementUseCase;
    }

    public AccountDTO createAccount(AccountDTO accountDTO) {
        return AccountDTOMapper.toAccountDTO(
                createAccountUseCase.apply(AccountDTOMapper.toAccount(accountDTO), accountDTO.getClientIdentification())
        );
    }

    public List<AccountStatementResponseDTO> getAccountStatements(String dateRange, String customerIdentification) {

        return getAccountStatementUseCase.apply(dateRange, customerIdentification)
                .stream()
                .map( data ->
                        new  AccountStatementResponseDTO(
                                data.getAccountNumber(),
                                data.getAccountInitialBalance(),
                                data.getAccountAvailableBalance(),
                                data.getAccountType(),
                                data.getCustomerName(),
                                data.isStatus(),
                                data.getMovementAmount(),
                                data.getDate()
                        )
                )
                .collect(Collectors.toList());
    }
}
