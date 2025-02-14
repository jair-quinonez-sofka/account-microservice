package ec.com.sofka.customer;

import ec.com.sofka.person.Person;

public class Customer extends Person {
    private String customerId;
    private String password;
    private boolean status;


    public Customer(String name, String gender, int age, String identification, String address, String phone, String customerId, String password, boolean status) {
        super(name, gender, age, identification, address, phone);
        this.customerId = customerId;
        this.password = password;
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
}
