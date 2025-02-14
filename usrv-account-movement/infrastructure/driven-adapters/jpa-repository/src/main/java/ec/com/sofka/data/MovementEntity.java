package ec.com.sofka.data;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movement")
public class MovementEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "movement_type")
    private String movementType;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "initial_balance")
    private BigDecimal initialBalance;
    @Column(name = "account_number")
    private String accountNumber;


    @PrePersist
    public void prePersist() {
        if (this.date == null) {
            this.date = LocalDateTime.now();
        }
    }

    public MovementEntity(String id, String movementType, BigDecimal amount, BigDecimal balance, BigDecimal initialBalance, String accountNumber) {
        this.id = id;
        this.movementType = movementType;
        this.amount = amount;
        this.balance = balance;
        this.initialBalance = initialBalance;
        this.accountNumber = accountNumber;
    }

    public MovementEntity() {

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getDate() {
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

    public BigDecimal getInitialBalance() {
        return initialBalance;
    }
}
