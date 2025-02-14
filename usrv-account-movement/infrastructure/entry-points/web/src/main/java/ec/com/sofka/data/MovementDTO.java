package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MovementDTO {
    @NotNull(message = "date cannot be null")
    private String date;
    @NotNull(message = "movementType cannot be null")
    private String movementType;
    @NotNull(message = "amount cannot be null")
    private BigDecimal amount;
    @NotNull(message = "balance cannot be null")
    private BigDecimal balance;

    public MovementDTO(String date, String movementType, BigDecimal amount, BigDecimal balance) {
        this.date = date;
        this.movementType = movementType;
        this.amount = amount;
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public String getMovementType() {
        return movementType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
