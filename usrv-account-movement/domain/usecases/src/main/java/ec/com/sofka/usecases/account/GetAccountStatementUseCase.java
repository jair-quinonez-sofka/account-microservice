package ec.com.sofka.usecases.account;

import ec.com.sofka.account.Account;
import ec.com.sofka.data.AccountStatementDTO;
import ec.com.sofka.data.CustomerInfoRecord;
import ec.com.sofka.data.CustomerInfoRequestRecord;
import ec.com.sofka.gateway.IAccountRepository;
import ec.com.sofka.gateway.IBusMessage;
import ec.com.sofka.gateway.IMovementRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetAccountStatementUseCase {
    private final IAccountRepository accountRepository;
    private final IMovementRepository movementRepository;
    private final IBusMessage busMessage;

    public GetAccountStatementUseCase(IAccountRepository accountRepository, IMovementRepository movementRepository, IBusMessage busMessage) {
        this.accountRepository = accountRepository;
        this.movementRepository = movementRepository;
        this.busMessage = busMessage;
    }

    public List<AccountStatementDTO> apply(String dateRange, String identification) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] dates = dateRange.split("-");
        if (dates.length != 2) {
            throw new IllegalArgumentException("Invalid date range format. Use dd/MM/yyyy-dd/MM/yyyy");
        }
        LocalDate startDate = LocalDate.parse(dates[0], formatter);
        LocalDate endDate = LocalDate.parse(dates[1], formatter);
        LocalDateTime startDateTime = startDate.atStartOfDay();
        LocalDateTime endDateTime = endDate.atTime(23, 59, 59);
        Object response = busMessage.sendMessage(new CustomerInfoRequestRecord(identification, true));
        CustomerInfoRecord info = (CustomerInfoRecord) response;

        if (info == null || info.customerId().isEmpty() &&  info.name().isEmpty()) {
            throw new RuntimeException("Error creating account statement: Customer info not Found");
        }

        Account account = accountRepository.findByCustomerId(info.customerId())
                .orElseThrow(() ->new RuntimeException("Account not found"));



        return movementRepository.findMovementsByDateRangeAndCustomer(startDateTime, endDateTime, account.getAccountNumber())
                .stream()
                .map(movement -> new AccountStatementDTO(
                        account.getAccountNumber(),
                        movement.getInitialBalance(),
                        movement.getBalance(),
                        account.getAccountType(),
                        info.name(),
                        account.isStatus(),
                        movement.getAmount(),
                        movement.getDate()
                ))
                .toList();
    }
}
