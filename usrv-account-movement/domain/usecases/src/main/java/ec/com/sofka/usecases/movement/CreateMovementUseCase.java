package ec.com.sofka.usecases.movement;

import ec.com.sofka.account.Account;
import ec.com.sofka.data.MovementTypeEnum;
import ec.com.sofka.gateway.IAccountRepository;
import ec.com.sofka.gateway.IBusMessage;
import ec.com.sofka.gateway.IMovementRepository;
import ec.com.sofka.movement.Movement;
import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

public class CreateMovementUseCase {
    private final IMovementRepository movementRepository;
    private final IAccountRepository accountRepository;
    private final IBusMessage busMessage;

    public CreateMovementUseCase(IMovementRepository movementRepository, IAccountRepository accountRepository, IBusMessage busMessage) {
        this.movementRepository = movementRepository;
        this.accountRepository = accountRepository;
        this.busMessage = busMessage;
    }


    @Transactional
    public Movement apply(Movement movement) {
        Account account = accountRepository.findAccountByAccountNumber(movement.getAccountNumber())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        BigDecimal newBalance = account.getInitialBalance().add(movement.getAmount());

        if (newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Balance not available");
        }
        movement.setInitialBalance(account.getInitialBalance());
        movement.setMovementType(movement.getAmount().compareTo(BigDecimal.ZERO) < 0 ?
                MovementTypeEnum.WITHDRAW.name() :
                MovementTypeEnum.DEPOSIT.name());

        account.setInitialBalance(newBalance);
        accountRepository.save(account);

        movement.setBalance(newBalance);
        return movementRepository.save(movement);
    }

}

