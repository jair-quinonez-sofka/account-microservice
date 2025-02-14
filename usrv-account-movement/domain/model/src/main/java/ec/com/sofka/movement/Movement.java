package ec.com.sofka.movement;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Movement {

    private String id;
    private LocalDateTime date;
    private String movementType;
    private BigDecimal amount;
    private BigDecimal balance;
    private BigDecimal initialBalance;
    private String accountNumber;

    public Movement(String id, LocalDateTime date, String movementType, BigDecimal amount, BigDecimal balance, BigDecimal initialBalance, String accountNumber) {
        this.id = id;
        this.date = date;
        this.movementType = movementType;
        this.amount = amount;
        this.balance = balance;
        this.initialBalance = initialBalance;
        this.accountNumber = accountNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(BigDecimal initialBalance) {
        this.initialBalance = initialBalance;
    }
}
