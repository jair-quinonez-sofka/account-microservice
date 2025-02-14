package ec.com.sofka.data;

import jakarta.persistence.*;

import java.math.BigDecimal;
@Entity
@Table(name = "movement")
public class MovementEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @Column(name = "date")
    private String date;
    @Column(name = "movement_type")
    private String movementType;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "balance")
    private BigDecimal balance;

    public MovementEntity(String id, String date, String movementType, BigDecimal amount, BigDecimal balance) {
        this.id = id;
        this.date = date;
        this.movementType = movementType;
        this.amount = amount;
        this.balance = balance;
    }

    public MovementEntity() {

    }

    public String getId() {
        return id;
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
