package ec.com.sofka.mapper;

import ec.com.sofka.customer.Customer;
import ec.com.sofka.data.CustomerEntity;

public class CustomerEntityMapper {
    public static CustomerEntity toCustomerEntity(Customer customer) {
        return new CustomerEntity(
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getIdentification(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getCustomerId(),
                customer.getPassword(),
                customer.isStatus()
        );

    }

    public static Customer toCustomer(CustomerEntity customerEntity) {
        if (customerEntity == null) return null;
        return new Customer(
                customerEntity.getName(),
                customerEntity.getGender(),
                customerEntity.getAge(),
                customerEntity.getIdentification(),
                customerEntity.getAddress(),
                customerEntity.getPhone(),
                customerEntity.getCustomerId(),
                customerEntity.getPassword(),
                customerEntity.isStatus()
        );
    }
}
