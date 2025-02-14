package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class MovementDTO {
    @NotNull(message = "accountNumber cannot be null")
    private final String accountNumber;
    @NotNull(message = "amount cannot be null")
    private final BigDecimal amount;


    public MovementDTO(String accountNumber,BigDecimal amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public BigDecimal getAmount() {
        return amount;
    }
}
