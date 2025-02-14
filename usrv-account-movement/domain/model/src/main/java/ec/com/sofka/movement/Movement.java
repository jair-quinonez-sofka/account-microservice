package ec.com.sofka.movement;

import java.math.BigDecimal;

public class Movement {

    private String id;
    private String date;
    private String movementType;
    private BigDecimal amount;
    private BigDecimal balance;

    public Movement(String id, String date, String movementType, BigDecimal amount, BigDecimal balance) {
        this.id = id;
        this.date = date;
        this.movementType = movementType;
        this.amount = amount;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
}
