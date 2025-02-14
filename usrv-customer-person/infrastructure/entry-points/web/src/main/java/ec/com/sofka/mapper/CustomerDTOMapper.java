package ec.com.sofka.mapper;

import ec.com.sofka.customer.Customer;
import ec.com.sofka.data.CustomerDTO;
import ec.com.sofka.data.CustomerEntity;
import ec.com.sofka.data.CustomerResponseDTO;

public class CustomerDTOMapper {

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO(
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getPassword(),
                customer.isStatus()
        );
    }

    public static Customer toCustomer(CustomerDTO customer) {
        return new Customer(
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone(),
                null,
                customer.getPassword(),
                customer.isStatus()
        );
    }

    public static CustomerResponseDTO toCustomerResponseDTO(Customer customer) {
        return new CustomerResponseDTO(
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone(),
                customer.isStatus()
        );
    }
}
