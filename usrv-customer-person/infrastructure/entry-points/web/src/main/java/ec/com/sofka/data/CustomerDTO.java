package ec.com.sofka.data;

import jakarta.validation.constraints.NotNull;

public class CustomerDTO {

    @NotNull(message = "name cannot be null")
    private String name;
    @NotNull(message = "gender cannot be null")
    private String gender;
    @NotNull(message = "age cannot be null")
    private int age;
    @NotNull(message = "identification cannot be null")
    private String identification;
    @NotNull(message = "address cannot be null")
    private String address;
    @NotNull(message = "phone cannot be null")
    private String phone;
    @NotNull(message = "password cannot be null")
    private String password;
    private boolean status;

    public CustomerDTO(String name, String gender, int age, String identification, String address, String phone, String password, boolean status) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
