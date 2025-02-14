package ec.com.sofka.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MovementResponseDTO {
    private final String accountNumber;
    private final BigDecimal amount;
    private final BigDecimal balance;
    private final LocalDateTime date;
    private final String movementType;

    public MovementResponseDTO(String accountNumber, BigDecimal amount, BigDecimal balance, LocalDateTime date, String movementType) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
        this.movementType = movementType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMovementType() {
        return movementType;
    }
}
