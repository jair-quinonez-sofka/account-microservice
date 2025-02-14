package ec.com.sofka.data;

public class CustomerResponseDTO {
    private final String name;
    private final String gender;
    private final int age;
    private final String identification;
    private final String address;
    private final String phone;
    private final boolean status;

    public CustomerResponseDTO(String name, String gender, int age, String identification, String address, String phone, boolean status) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.identification = identification;
        this.address = address;
        this.phone = phone;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getIdentification() {
        return identification;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isStatus() {
        return status;
    }
}
