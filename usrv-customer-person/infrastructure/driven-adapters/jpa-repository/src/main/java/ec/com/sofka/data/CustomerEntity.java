package ec.com.sofka.data;

import jakarta.persistence.*;

@Entity
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(columnNames = "customer_id"))
public class CustomerEntity extends PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "password")
    private String password;
    @Column(name = "status")
    private boolean status;

    public CustomerEntity(String name, String gender, int age, String identification, String address, String phone, String customerId, String password, boolean status) {
        super(name, gender, age, identification, address, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public CustomerEntity() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
